package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.item.Content;

import java.util.HashMap;
import java.util.Map;

public class ItemVersionData {
  private Map<String, Content> contents = new HashMap<>();

  public Map<String, Content> getContents() {
    return contents;
  }

  public void setContents(
      Map<String, Content> contents) {
    this.contents = contents;
  }
}
