package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;

import java.util.Collection;
import java.util.List;

public class EntityInfo {
  private Id elementId;
  private Info info;
  private List<Relation> relations;
  private Collection<Id> contentIds;

  public EntityInfo() {
  }

  public EntityInfo(CoreEntity entity) {
    setElementId(entity.getElementId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
  }

  public Id getElementId() {
    return elementId;
  }

  public void setElementId(Id elementId) {
    this.elementId = elementId;
  }

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

  public Collection<Id> getContentIds() {
    return contentIds;
  }

  public void setContentIds(Collection<Id> contentIds) {
    this.contentIds = contentIds;
  }
}
