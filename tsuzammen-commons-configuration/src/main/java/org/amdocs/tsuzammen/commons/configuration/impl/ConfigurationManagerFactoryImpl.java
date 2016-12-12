package org.amdocs.tsuzammen.commons.configuration.impl;

import org.amdocs.tsuzammen.commons.configuration.ConfigurationManager;
import org.amdocs.tsuzammen.commons.configuration.ConfigurationManagerFactory;
import org.amdocs.tsuzammen.commons.datatypes.SessionContext;

public class ConfigurationManagerFactoryImpl extends ConfigurationManagerFactory {

  private static final ConfigurationManager INSTANCE = new ConfigurationManagerImpl();

  @Override
  public ConfigurationManager createInterface() {
    return INSTANCE;
  }
}

