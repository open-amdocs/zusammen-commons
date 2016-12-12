package org.amdocs.tsuzammen.commons.datatypes.impl;

/**
 * Created by TALIG on 12/1/2016.
 */
public class NamespaceId {
  private String id;
  private NamespaceId parentId;

  public NamespaceId(String id, NamespaceId parentId) {
    this.id = id;
    this.parentId = parentId;
  }

  public String getId() {
    return id;
  }

  public NamespaceId getParentId() {
    return parentId;
  }
}
