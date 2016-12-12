package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.List;

/**
 * Created by TALIG on 11/29/2016.
 */
public class Item {
  private Info info;
  private List<ItemVersion> versions;

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public List<ItemVersion> getVersions() {
    return versions;
  }

  public void setVersions(List<ItemVersion> versions) {
    this.versions = versions;
  }
}
