package org.amdocs.tsuzammen.commons.datatypes.item;

import org.amdocs.tsuzammen.commons.datatypes.ItemVersionKey;

import java.util.Map;

/**
 * Created by TALIG on 11/27/2016.
 */
public class RelationInfo {
  private String type;
  private Map<String, String> tags;
  private ItemVersionKey source;
  private ItemVersionKey target;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Map<String, String> getTags() {
    return tags;
  }

  public void setTags(Map<String, String> tags) {
    this.tags = tags;
  }

  public ItemVersionKey getSource() {
    return source;
  }

  public void setSource(ItemVersionKey source) {
    this.source = source;
  }

  public ItemVersionKey getTarget() {
    return target;
  }

  public void setTarget(ItemVersionKey target) {
    this.target = target;
  }
}
