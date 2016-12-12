package org.amdocs.tsuzammen.commons.db.impl.cassandra;

import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnector;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnectorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TALIG on 12/6/2016.
 */
public class CassandraConnectorFactoryImpl extends CassandraConnectorFactory {

  private static final String DEFAULT_CONNECTOR_KEY = "default";
  private static Map<String, CassandraConnector> connectorByTenant = new HashMap<>();

  @Override
  public CassandraConnector createInterface(SessionContext context) {
    String connectorKey = context.getTenant().orElse(DEFAULT_CONNECTOR_KEY);
    CassandraConnector connector = connectorByTenant.get(connectorKey);
    return connector == null ? create(connectorKey) : connector;
  }

  private CassandraConnector create(String keyspace) {
    CassandraConnector connector =
        new CassandraConnectorImpl(CassandraSessionFactory.getSession(keyspace));
    connectorByTenant.put(keyspace, connector);
    return connector;
  }
}
