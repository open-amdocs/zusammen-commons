package org.amdocs.tsuzammen.commons.datatypes.item;

import org.amdocs.tsuzammen.commons.datatypes.LocalizedValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TALIG on 11/28/2016.
 */
public class Info {
  //private List<LocalizedValue> name;
  //private List<LocalizedValue> description;
  private Map<String, Object> properties = new HashMap<>();

  public Info(){}

  /*public List<LocalizedValue> getName() {
    return name;
  }

  public void setName(List<LocalizedValue> name) {
    this.name = name;
  }

  public List<LocalizedValue> getDescription() {
    return description;
  }

  public void setDescription(
      List<LocalizedValue> description) {
    this.description = description;
  }
*/
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
