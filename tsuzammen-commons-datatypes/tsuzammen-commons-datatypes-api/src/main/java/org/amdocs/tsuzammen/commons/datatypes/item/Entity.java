package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TALIG on 11/28/2016.
 */
public class Entity {
  private String oid;
  private Info info;
  private Object data;
  private Object visualization;
  private List<RelationInfo> relations;

  private Map<String, Content> contents = new HashMap<>();

  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
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

  public List<RelationInfo> getRelations() {
    return relations;
  }

  public void setRelations(
      List<RelationInfo> relations) {
    this.relations = relations;
  }
}
