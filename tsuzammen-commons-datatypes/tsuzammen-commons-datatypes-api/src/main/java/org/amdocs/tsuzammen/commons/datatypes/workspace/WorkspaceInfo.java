package org.amdocs.tsuzammen.commons.datatypes.workspace;

import org.amdocs.tsuzammen.commons.datatypes.item.Info;

public class WorkspaceInfo {
  private String id;
  private Info info;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }
}
