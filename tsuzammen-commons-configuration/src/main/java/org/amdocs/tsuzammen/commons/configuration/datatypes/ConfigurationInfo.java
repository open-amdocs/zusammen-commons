package org.amdocs.tsuzammen.commons.configuration.datatypes;

public class ConfigurationInfo {
  private Configuration configuration;

  private int level;

  public Configuration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Configuration configuration) {
    this.configuration = configuration;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
