package org.amdocs.tsuzammen.commons.db.impl.cassandra;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import org.amdocs.tsuzammen.commons.db.api.cassandra.CassandraConnector;

/**
 * Created by TALIG on 12/6/2016.
 */
public class CassandraConnectorImpl implements CassandraConnector {
  private final Session session;
  private final MappingManager mappingManager;

  CassandraConnectorImpl(Session session) {
    this.session = session;
    mappingManager = new MappingManager(this.session);
  }

  @Override
  public MappingManager getMappingManager() {
    return mappingManager;
  }
}
