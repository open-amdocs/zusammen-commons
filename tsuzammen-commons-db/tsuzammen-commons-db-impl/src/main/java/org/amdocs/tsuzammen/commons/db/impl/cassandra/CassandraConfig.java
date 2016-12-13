package org.amdocs.tsuzammen.commons.db.impl.cassandra;

import org.amdocs.tsuzammen.commons.configuration.impl.ConfigurationAccessor;

import java.util.List;
import java.util.Optional;

class CassandraConfig {

  private static final String NODES = "cassandra.nodes";
  private static final String KEYSPACE = "cassandra.keyspace";
  private static final String USER = "cassandra.user";
  private static final String PASSWORD = "cassandra.password";
  private static final String AUTHENTICATE = "cassandra.authenticate";
  private static final String SSL = "cassandra.ssl";
  private static final String SSL_PORT = "cassandra.ssl.port";
  private static final String TRUST_STORE = "cassandra.truststore";
  private static final String TRUST_STORE_PASSWORD = "cassandra.truststore.password";

  static String[] getNodes() {
    List<String> nodes = ConfigurationAccessor.getProperty(NODES);
    return nodes.toArray(new String[nodes.size()]);
  }

  static String getKeyspace() {
    return ConfigurationAccessor.getProperty(KEYSPACE);
  }

  static String getUser() {
    return ConfigurationAccessor.getProperty(USER);
  }

  static String getPassword() {
    return ConfigurationAccessor.getProperty(PASSWORD);
  }

  static boolean isAuthenticate() {
    return ConfigurationAccessor.getProperty(AUTHENTICATE);
  }

  static boolean isSsl() {
    return ConfigurationAccessor.getProperty(SSL);
  }

  static Optional<Integer> getSslPort() {
    Optional<String> sslPort = ConfigurationAccessor.getOptionalProperty(SSL_PORT);
    return sslPort.map(Integer::parseInt);
  }

  static Optional<String> getTrustStore() {
    return ConfigurationAccessor.getOptionalProperty(TRUST_STORE);
  }

  static Optional<String> getTrustStorePassword() {
    return ConfigurationAccessor.getOptionalProperty(TRUST_STORE_PASSWORD);
  }
}
