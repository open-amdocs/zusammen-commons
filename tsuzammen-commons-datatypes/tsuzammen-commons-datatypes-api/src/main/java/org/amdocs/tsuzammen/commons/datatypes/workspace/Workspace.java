package org.amdocs.tsuzammen.commons.datatypes.workspace;

import org.amdocs.tsuzammen.commons.datatypes.ItemVersionKey;

import java.util.ArrayList;
import java.util.List;

public class Workspace {
  private List<ItemVersionKey> items = new ArrayList<>();

  public List<ItemVersionKey> getItems() {
    return items;
  }

  public void setItems(List<ItemVersionKey> items) {
    this.items = items;
  }


}
