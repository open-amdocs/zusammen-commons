package org.amdocs.tsuzammen.commons.configuration.impl;

import org.amdocs.tsuzammen.commons.configuration.ConfigurationManager;
import org.amdocs.tsuzammen.commons.configuration.datatypes.Configuration;
import org.amdocs.tsuzammen.commons.configuration.datatypes.PluginInfo;
import org.amdocs.tsuzammen.commons.configuration.utils.AggregateConfigurationFiles;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

class ConfigurationManagerImpl implements ConfigurationManager {
  private static Configuration configurationInfo;

  ConfigurationManagerImpl() {
    synchronized (ConfigurationManagerImpl.class) {

      List<InputStream> configurationFileInputStreamList =
          FileUtils.getFileInputStreams("tsuzammen.json");
      configurationInfo = AggregateConfigurationFiles.aggregate(configurationFileInputStreamList);

    }
  }

  @Override
  public PluginInfo getPluginInfo(String pluginType) {
    PluginInfo pluginInfo = configurationInfo.getPlugins().get(pluginType);
    if (pluginInfo == null) {
      throw new RuntimeException("Plugin type:" + pluginType + " not supported.");
    }
    return pluginInfo;
  }

  @Override
  public <T> Optional<T> getProperty(String propertyName) {
    Object value = configurationInfo.getProperties().get(propertyName);
    if (value == null) {
      value = System.getProperty(propertyName);
      if (value == null) {
        return Optional.empty();
      }
    }
    return Optional.of((T) value);
  }
}
