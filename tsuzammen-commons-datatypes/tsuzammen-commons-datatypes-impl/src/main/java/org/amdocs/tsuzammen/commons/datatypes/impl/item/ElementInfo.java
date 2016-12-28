package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.item.Element;
import org.amdocs.tsuzammen.commons.datatypes.item.ElementId;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;

import java.util.Collection;

public class ElementInfo {
  private ElementId elementId;
  private Id parentId; //core uses for save
  private Collection<Relation> relations;
  private Collection<ElementId> subElementIds; //core uses for get

  // used by state-store on get operations
  public ElementInfo() {
  }

  // used by core on save operations
  public ElementInfo(Element element/*, Id parentId*/) {
    setElementId(new ElementId(element.getElementId(), element.getInfo()));
    //setParentId(parentId);
    setRelations(element.getRelations());
  }

  public ElementId getElementId() {
    return elementId;
  }

  public void setElementId(ElementId elementId) {
    this.elementId = elementId;
  }

  public Id getParentId() {
    return parentId;
  }

  public void setParentId(Id parentId) {
    this.parentId = parentId;
  }

  public Collection<Relation> getRelations() {
    return relations;
  }

  public void setRelations(Collection<Relation> relations) {
    this.relations = relations;
  }

  public Collection<ElementId> getSubElementIds() {
    return subElementIds;
  }

  public void setSubElementIds(
      Collection<ElementId> subElementIds) {
    this.subElementIds = subElementIds;
  }
}
