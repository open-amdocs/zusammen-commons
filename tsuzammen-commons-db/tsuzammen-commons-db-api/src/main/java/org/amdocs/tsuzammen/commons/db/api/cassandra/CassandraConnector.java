package org.amdocs.tsuzammen.commons.db.api.cassandra;

import com.datastax.driver.mapping.MappingManager;

/**
 * Created by TALIG on 12/7/2016.
 */
public interface CassandraConnector {
  MappingManager getMappingManager();
}
