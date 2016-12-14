package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
  private String id;
  private Info info;
  private List<Relation> relations;
  private Object data;
  private Object visualization;
  private Map<String, Content> contents = new HashMap<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Object getVisualization() {
    return visualization;
  }

  public void setVisualization(Object visualization) {
    this.visualization = visualization;
  }

  public Map<String, Content> getContents() {
    return contents;
  }

  public void setContents(
      Map<String, Content> contents) {
    this.contents = contents;
  }
}
