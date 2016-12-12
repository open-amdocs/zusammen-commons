package org.amdocs.tsuzammen.commons.datatypes;

/**
 * Created by TALIG on 11/27/2016.
 */
public class Id {

  private String value;

  public Id() {
  }

  public Id(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Id id = (Id) o;

    return value != null ? value.equals(id.value) : id.value == null;

  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
