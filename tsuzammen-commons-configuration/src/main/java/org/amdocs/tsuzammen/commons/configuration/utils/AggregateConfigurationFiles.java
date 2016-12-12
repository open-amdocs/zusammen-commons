package org.amdocs.tsuzammen.commons.configuration.utils;


import org.amdocs.tsuzammen.commons.configuration.datatypes.Configuration;
import org.amdocs.tsuzammen.commons.configuration.datatypes.ConfigurationInfo;
import org.amdocs.tsuzammen.commons.configuration.datatypes.PluginInfo;
import org.amdocs.tsuzammen.utils.fileutils.json.JsonUtil;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AggregateConfigurationFiles {

  public static Configuration aggregate(List<InputStream> configurationFiles) {
    Configuration configuration = new Configuration();
    configurationFiles.stream()
        .map(configurationFile -> JsonUtil.json2Object(configurationFile, ConfigurationInfo.class))
        .sorted(Comparator.comparingInt(ConfigurationInfo::getLevel))
        .forEach(configurationInfo
            -> overrideConfiguration(configuration, configurationInfo.getConfiguration()));
    return configuration;
  }

  private static void overrideConfiguration(Configuration baseConfiguration,
                                            Configuration overrideConfiguration) {
    overrideProperties(baseConfiguration.getProperties(), overrideConfiguration.getProperties());
    overridePlugins(baseConfiguration, overrideConfiguration);
  }

  private static void overrideProperties(Map<String, Object> baseProperties,
                                         Map<String, Object> overrideProperties) {
    if (baseProperties.size() > 0) {
      overrideProperties.keySet().forEach(
          propertyKey -> overrideProperty(propertyKey, baseProperties, overrideProperties));
    }
    baseProperties.putAll(overrideProperties);
  }

  private static void overrideProperty(String propertyKey,
                                       Map<String, Object> basePropertyInfo,
                                       Map<String, Object> overridePropertyInfo) {
    Object propertyValue = overridePropertyInfo.get(propertyKey);
    if (propertyValue == null) {
      basePropertyInfo.remove(propertyKey);
    } else {
      basePropertyInfo.put(propertyKey, propertyValue);
    }
  }

  private static void overridePlugins(Configuration baseConfiguration,
                                      Configuration overrideConfiguration) {
    if (overrideConfiguration.getPlugins().size() == 0) {
      return;
    }
    if (baseConfiguration.getPlugins().size() == 0) {
      baseConfiguration.setPlugins(overrideConfiguration.getPlugins());
    } else {
      overrideConfiguration.getPlugins().entrySet().forEach(pluginEntry -> {
        if (baseConfiguration.getPlugins().containsKey(pluginEntry.getKey())) {
          overridePlugin(baseConfiguration.getPlugins().get(pluginEntry.getKey()),
              pluginEntry.getValue());
        } else {
          baseConfiguration.getPlugins().put(pluginEntry.getKey(), pluginEntry.getValue());
        }
      });
    }
  }

  private static void overridePlugin(PluginInfo basePluginInfo, PluginInfo overridePluginInfo) {
    if (overridePluginInfo.getImplementationClass() != null) {
      basePluginInfo.setImplementationClass(overridePluginInfo.getImplementationClass());
    }
    overrideProperties(basePluginInfo.getProperties(), overridePluginInfo.getProperties());
  }
}
