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

import com.amdocs.zusammen.commons.configuration.impl.ConfigurationAccessor;

import java.util.List;
import java.util.Optional;

class CassandraConfig {
  static private final Integer DEAFAULT_CASSANDRA_PORT = 9042;
  static private final Long DEAFAULT_CASSANDRA_RECONNECT_TIMEOUT = 30000L;
  private static final String NODES = "cassandra.nodes";
  private static final String KEYSPACE = "cassandra.keyspace";
  private static final String USER = "cassandra.user";
  private static final String PASSWORD = "cassandra.password";
  private static final String AUTHENTICATE = "cassandra.authenticate";
  private static final String SSL = "cassandra.ssl";
  private static final String SSL_PORT = "cassandra.ssl.port";
  private static final String TRUST_STORE = "cassandra.truststore";
  private static final String TRUST_STORE_PASSWORD = "cassandra.truststore.password";
  private static final String DATA_CENTER = "cassandra.datacenter";
  private static final String CONSISTENCY_LEVEL = "cassandra.consistency.level";
  private static final String CASSANDRA_PORT_KEY = "cassandra.cassandraPort";
  private static final String CASSANDRA_RECONNECT_TIMEOUT = "cassandra.reconnectTimeout";

  static String[] getNodes() {
    Object nodesObject = ConfigurationAccessor.getProperty(NODES);
    if(nodesObject instanceof List){
      List<String> nodes =  (List<String>)nodesObject;
      return nodes.toArray(new String[nodes.size()]);
    }else{
      return ((String)nodesObject).split(",");
    }


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
    return getBoolean(ConfigurationAccessor.getProperty(AUTHENTICATE));
  }

  static boolean isSsl() {
    return getBoolean(ConfigurationAccessor.getProperty(SSL));
  }

  static Optional<Integer> getCassandraPort() {
    Optional<String> cassandraPort = ConfigurationAccessor.getOptionalProperty(CASSANDRA_PORT_KEY);
    if(!cassandraPort.isPresent()){
      return Optional.of(DEAFAULT_CASSANDRA_PORT);
    }
    return Optional.of(Integer.valueOf(cassandraPort.get()));
  }

  /**
   * Gets Cassandra reconnection timeout
   *
   * @return
   */
  public static Optional<Long> getReconnectTimeout() {
    Optional<String> cassandraReconnectTimeout = ConfigurationAccessor.getOptionalProperty(CASSANDRA_RECONNECT_TIMEOUT);
    if(!cassandraReconnectTimeout.isPresent()){
      return Optional.of(DEAFAULT_CASSANDRA_RECONNECT_TIMEOUT);
    }
    return Optional.of(Long.parseLong(cassandraReconnectTimeout.get()));
  }

  static Optional<String> getTrustStore() {
    return ConfigurationAccessor.getOptionalProperty(TRUST_STORE);
  }

  static Optional<String> getTrustStorePassword() {
    return ConfigurationAccessor.getOptionalProperty(TRUST_STORE_PASSWORD);
  }

  static boolean getBoolean(Object value){
    if(value instanceof String){
      return "true".equals(value);
    }
    return ((Boolean)value).booleanValue();

  }

  public static Optional<String>  getDataCenter() {
    return ConfigurationAccessor.getOptionalProperty(DATA_CENTER);
  }

  public static Optional<String>  getConsistencyLevel() {
    return ConfigurationAccessor.getOptionalProperty(CONSISTENCY_LEVEL);
  }
}
