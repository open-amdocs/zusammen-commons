package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;

import java.util.Collection;
import java.util.List;

public class EntityInfo {
  private String id;
  private String parentId;
  private Collection<String> contents;
  private Info info;
  private List<Relation> relations;

  public EntityInfo(CoreEntity entity) {
    setId(entity.getId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public Collection<String> getContents() {
    return contents;
  }

  public void setContents(Collection<String> contents) {
    this.contents = contents;
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
}
