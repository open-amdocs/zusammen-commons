package org.amdocs.tsuzammen.commons.configuration;

import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.utils.facade.api.AbstractComponentFactory;
import org.amdocs.tsuzammen.utils.facade.api.AbstractFactory;

public abstract class ConfigurationManagerFactory
    extends AbstractComponentFactory<ConfigurationManager> {

  public static ConfigurationManagerFactory getInstance() {
    return AbstractFactory.getInstance(ConfigurationManagerFactory.class);
  }

  abstract public ConfigurationManager createInterface();
}
