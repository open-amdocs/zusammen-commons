package org.amdocs.tsuzammen.commons.db.api.cassandra;

import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.utils.facade.api.AbstractComponentFactory;
import org.amdocs.tsuzammen.utils.facade.api.AbstractFactory;

/**
 * Created by TALIG on 12/6/2016.
 */
public abstract class CassandraConnectorFactory
    extends AbstractComponentFactory<CassandraConnector> {

  public static CassandraConnectorFactory getInstance() {
    return AbstractFactory.getInstance(CassandraConnectorFactory.class);
  }

  public abstract CassandraConnector createInterface(SessionContext context);
}
