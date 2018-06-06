/*
 * Copyright © 2016-2017 European Support Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amdocs.zusammen.commons.db.impl.cassandra;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.RemoteEndpointAwareJdkSSLOptions;
import com.datastax.driver.core.SSLOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.LoadBalancingPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

class CassandraSessionFactory {

    private static final long SHUTDOWN_TIMEOUT = 10;
    private static final String DEFAULT_KEYSPACE = CassandraConfig.getKeyspace();
    private static final String TENANT_KEYSPACE_PREFIX = DEFAULT_KEYSPACE + "_";

    private static Cluster cluster = initCluster();
    private static Map<String, Session> sessionByKeyspace = new HashMap<>();

    static Session getSession(String tenant) {
        String keyspace = tenant == null ? DEFAULT_KEYSPACE : TENANT_KEYSPACE_PREFIX + tenant;
        Session session = sessionByKeyspace.get(keyspace);
        return session == null ? initSession(keyspace) : session;
    }

    private static Session initSession(String keyspace) {
        Session session = cluster.connect(keyspace);
        sessionByKeyspace.put(keyspace, session);
        return session;
    }

    private static Cluster initCluster() {
        String[] nodes = CassandraConfig.getNodes();
        if (nodes.length == 0) {
            throw new IllegalStateException("no nodes specified");
        }
        Builder builder = Cluster.builder();
        builder.addContactPoints(nodes);

        if (CassandraConfig.isSsl()) {
            getSSLOptions().ifPresent(builder::withSSL);
        }
        CassandraConfig.getSslPort().ifPresent(builder::withPort);
        if (CassandraConfig.isAuthenticate()) {
            builder.withCredentials(CassandraConfig.getUser(), CassandraConfig.getPassword());
        }

        Optional<String> dataCenter = CassandraConfig.getDataCenter();
        if (dataCenter.isPresent()) {
            LoadBalancingPolicy tokenAwarePolicy =
                    new TokenAwarePolicy(DCAwareRoundRobinPolicy.builder().withLocalDc(dataCenter.get()).build());
            builder.withLoadBalancingPolicy(tokenAwarePolicy);
        }
        if (nodes != null && nodes.length > 1) {
            CassandraConfig.getConsistencyLevel().ifPresent(
                    s -> builder.withQueryOptions(new QueryOptions().setConsistencyLevel(ConsistencyLevel.valueOf(s))));
        }
        return builder.build();
    }

    void shutdown() {
        if (cluster != null) {
            try {
                // Close asynchronously, then get with our timeout value
                // get will throw exception if timeout exceeded, or close fails
                cluster.closeAsync().get(SHUTDOWN_TIMEOUT, SECONDS);
            } catch (Exception e) {
                throw new RuntimeException("Unable to shutdown cluster", e);
            }
        }
    }

    private static Optional<SSLOptions> getSSLOptions() {
        Optional<String> truststore = CassandraConfig.getTrustStore();
        Optional<String> truststorePassword = CassandraConfig.getTrustStorePassword();

        if (truststore.isPresent() && truststorePassword.isPresent()) {
            SSLContext context;
            try {
                context = getSSLContext(truststore.get(), truststorePassword.get());
            } catch (UnrecoverableKeyException | KeyManagementException | NoSuchAlgorithmException | KeyStoreException | CertificateException | IOException e) {
                throw new RuntimeException(e);
            }
            String[] css = new String[] {"TLS_RSA_WITH_AES_128_CBC_SHA"};
            return Optional.of(
                    RemoteEndpointAwareJdkSSLOptions.builder().withSSLContext(context).withCipherSuites(css).build());
        }
        return Optional.empty();
    }

    private static SSLContext getSSLContext(String truststorePath, String truststorePassword)
            throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
                           UnrecoverableKeyException, KeyManagementException {
        SSLContext ctx = null;
        try (FileInputStream tsf = new FileInputStream(truststorePath)) {
            ctx = SSLContext.getInstance("SSL");

            KeyStore ts = KeyStore.getInstance("JKS");
            ts.load(tsf, truststorePassword.toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(ts);

          /*  KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(ksf, keystorePassword.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, keystorePassword.toCharArray());*/

            ctx.init(null, tmf.getTrustManagers(), new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctx;
    }


}
