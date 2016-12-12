package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TALIG on 11/29/2016.
 */
public class ItemVersion {
  private Info info;
  private List<RelationInfo> relations;
  private Map<String, Content> contents = new HashMap<>();

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public List<RelationInfo> getRelations() {
    return relations;
  }

  public void setRelations(
      List<RelationInfo> relations) {
    this.relations = relations;
  }

  public Map<String, Content> getContents() {
    return contents;
  }

  public void setContents(
      Map<String, Content> contents) {
    this.contents = contents;
  }
}
