package org.amdocs.tsuzammen.commons.db.impl.cassandra;

import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnector;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnectorFactory;

import java.util.HashMap;
import java.util.Map;

public class CassandraConnectorFactoryImpl extends CassandraConnectorFactory {

  private static final String DEFAULT_CONNECTOR_KEY = "default";
  private static Map<String, CassandraConnector> connectorByTenant = new HashMap<>();

  @Override
  public CassandraConnector createInterface(SessionContext context) {
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
