package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;

import java.util.List;

public class EntityInfo {
  private Info info;
  private List<Relation> relations;

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }


  public List<Relation> getRelations() {
    return relations;
  }

  public void setRelations(
      List<Relation> relations) {
    this.relations = relations;
  }
}
