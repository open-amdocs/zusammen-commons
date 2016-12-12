package org.amdocs.tsuzammen.commons.configuration.impl;

import org.amdocs.tsuzammen.commons.configuration.ConfigurationManagerFactory;

import java.util.Optional;


public class ConfigurationAccessor {

  private static final String MISSING_PROPERTY_MSG = "property %s does not exist";
  private static final String MISSING_PLUGIN_PROPERTY_MSG =
      "property %s does not exist for plugin %s";

  public static <T> T getProperty(String propertyName) {
    Optional<T> property = getOptionalProperty(propertyName);
    return property.orElseThrow(() ->
        new RuntimeException(String.format(MISSING_PROPERTY_MSG, propertyName)));
  }

  public static <T> Optional<T> getOptionalProperty(String propertyName) {
    Object value = System.getProperty(propertyName);
    return value == null ?
        ConfigurationManagerFactory.getInstance().createInterface().getProperty(propertyName) :
        Optional.of((T) value);
  }

  public static <T> T getPluginProperty(String pluginName, String propertyName) {
    Optional<T> property = getOptionalPluginProperty(pluginName, propertyName);
    return property.orElseThrow(() ->
        new RuntimeException(String.format(MISSING_PLUGIN_PROPERTY_MSG, propertyName, pluginName)));
  }

  public static <T> Optional<T> getOptionalPluginProperty(String pluginName, String propertyName) {
    Object value = System.getProperty(propertyName);
    if (value == null) {
      value = ConfigurationManagerFactory.getInstance().createInterface()
          .getPluginInfo(pluginName).getProperties().get(propertyName);

      if (value == null) {
        return Optional.empty();
      }
    }
    return Optional.of((T) value);
  }
}
