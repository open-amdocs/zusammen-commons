/*
 * Copyright © 2016 Amdocs Software Systems Limited
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

package org.amdocs.zusammen.commons.db.impl.cassandra;

import org.amdocs.zusammen.commons.configuration.impl.ConfigurationAccessor;

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
