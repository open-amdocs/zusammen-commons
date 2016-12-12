package org.amdocs.tsuzammen.commons.datatypes.workspace;

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;

public class WorkspaceInfo {
  private Id id;
  private Info info;

  public Id getId() {
    return id;
  }

  public void setId(Id id) {
    this.id = id;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }
}
