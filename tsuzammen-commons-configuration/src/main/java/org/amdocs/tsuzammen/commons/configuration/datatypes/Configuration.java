package org.amdocs.tsuzammen.commons.configuration.datatypes;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
  private Map<String, Object> properties = new HashMap<>();
  private Map<String, PluginInfo> plugins = new HashMap<>();

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public Map<String, PluginInfo> getPlugins() {
    return plugins;
  }

  public void setPlugins(Map<String, PluginInfo> plugins) {
    this.plugins = plugins;
  }
}
