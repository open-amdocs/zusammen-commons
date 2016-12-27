package org.amdocs.tsuzammen.commons.datatypes.item;

import org.amdocs.tsuzammen.commons.datatypes.Id;

import java.util.Collection;
import java.util.Map;

public class Content implements Element {
  private Id elementId;
  private Info info;
  private Collection<? extends Entity> entities;
  private Map<String, Content> contents;

  @Override
  public Id getElementId() {
    return elementId;
  }

  @Override
  public void setElementId(Id elementId) {
    this.elementId = elementId;
  }

  @Override
  public Info getInfo() {
    return info;
  }

  @Override
  public void setInfo(Info info) {
    this.info = info;
  }

  @Override
  public Collection<Relation> getRelations() {
    return null;
  }

  @Override
  public void setRelations(Collection<Relation> relations) {

  }

  @Override
  public Collection<Element> getSubElements() {
    return null;
  }

  @Override
  public void setSubElements(Collection<Element> subElements) {

  }


  public Collection<? extends Entity> getEntities() {
    return entities;
  }

  public void setEntities(Collection<? extends Entity> entities) {
    this.entities = entities;
  }

  public Map<String, Content> getContents() {
    return contents;
  }

  public void setContents(Map<String, Content> contents) {
    this.contents = contents;
  }

}
