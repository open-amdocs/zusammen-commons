package org.amdocs.tsuzammen.commons.datatypes;

/**
 * Created by TALIG on 11/27/2016.
 */
public class LocalizedValue {
  private static final String DEFAULT_LOCALE = "EN";

  private String value;
  private String locale;

  public LocalizedValue(){}

  public LocalizedValue(String value, String locale) {
    this.value = value;
    this.locale = locale;
  }

  public LocalizedValue(String value) {
    new LocalizedValue(value, DEFAULT_LOCALE);
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
}
