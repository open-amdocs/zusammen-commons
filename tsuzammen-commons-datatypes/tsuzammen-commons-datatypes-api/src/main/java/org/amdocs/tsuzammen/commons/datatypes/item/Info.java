package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.HashMap;
import java.util.Map;

public class Info {
  private String name;
  private String description;
  private Map<String, Object> properties = new HashMap<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Map<String, Object> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  public <T> void addProperty(String propertyName, T value) {
    properties.put(propertyName, value);
  }

  public <T> T getProperty(String propertyName) {
    return (T) properties.get(propertyName);
  }

}
