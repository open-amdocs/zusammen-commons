package org.amdocs.tsuzammen.commons.datatypes.impl;

/**
 * Created by TALIG on 12/1/2016.
 */
public class Namespace {
  private NamespaceId namespaceId;

  public Namespace(NamespaceId namespaceId) {
    this.namespaceId = namespaceId;
  }

  public NamespaceId getNamespaceId() {
    return namespaceId;
  }
}
