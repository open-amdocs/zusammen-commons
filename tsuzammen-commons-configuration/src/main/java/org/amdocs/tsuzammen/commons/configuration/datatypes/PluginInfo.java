package org.amdocs.tsuzammen.commons.configuration.datatypes;

import java.util.HashMap;
import java.util.Map;

public class PluginInfo {
  private String implementationClass;
  private Map<String, Object> properties = new HashMap<>();

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public String getImplementationClass() {
    return implementationClass;
  }

  public void setImplementationClass(String implementationClass) {
    this.implementationClass = implementationClass;
  }
}
