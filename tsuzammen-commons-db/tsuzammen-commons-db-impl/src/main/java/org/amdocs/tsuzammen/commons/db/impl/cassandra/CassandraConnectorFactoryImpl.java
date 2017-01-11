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

package org.amdocs.tsuzammen.commons.db.impl.cassandra;

import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnector;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnectorFactory;
import org.amdocs.tsuzammen.commons.db.api.cassandra.types.CassandraContext;

import java.util.HashMap;
import java.util.Map;

public class CassandraConnectorFactoryImpl extends CassandraConnectorFactory {

  private static final String DEFAULT_CONNECTOR_KEY = "default";
  private static Map<String, CassandraConnector> connectorByTenant = new HashMap<>();

  @Override
  public CassandraConnector createInterface(CassandraContext context) {
    String connectorKey = context.getTenant() == null ? DEFAULT_CONNECTOR_KEY : context.getTenant();
    CassandraConnector connector = connectorByTenant.get(connectorKey);
    return connector == null ? create(context.getTenant(), connectorKey) : connector;
  }

  private CassandraConnector create(String tenant, String connectorKey) {
    CassandraConnector connector =
        new CassandraConnectorImpl(CassandraSessionFactory.getSession(tenant));
    connectorByTenant.put(connectorKey, connector);
    return connector;
  }
}
