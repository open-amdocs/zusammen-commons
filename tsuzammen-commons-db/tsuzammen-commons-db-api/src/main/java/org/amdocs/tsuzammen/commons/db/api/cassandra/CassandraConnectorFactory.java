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

package org.amdocs.tsuzammen.commons.db.api.cassandra;

import org.amdocs.tsuzammen.commons.db.api.cassandra.types.CassandraContext;
import org.amdocs.tsuzammen.utils.facade.api.AbstractComponentFactory;
import org.amdocs.tsuzammen.utils.facade.api.AbstractFactory;


public abstract class CassandraConnectorFactory
    extends AbstractComponentFactory<CassandraConnector> {

  public static CassandraConnectorFactory getInstance() {
    return AbstractFactory.getInstance(CassandraConnectorFactory.class);
  }

  public abstract CassandraConnector createInterface(CassandraContext context);
}
