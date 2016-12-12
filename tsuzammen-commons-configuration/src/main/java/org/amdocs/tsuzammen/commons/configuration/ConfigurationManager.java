package org.amdocs.tsuzammen.commons.configuration;

import org.amdocs.tsuzammen.commons.configuration.datatypes.PluginInfo;

import java.util.Optional;

public interface ConfigurationManager {

  PluginInfo getPluginInfo(String pluginType);

  <T> Optional<T> getProperty(String propertyName);
}
