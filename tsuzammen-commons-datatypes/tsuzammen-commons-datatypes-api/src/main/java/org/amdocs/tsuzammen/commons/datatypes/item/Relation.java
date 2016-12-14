package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.Map;

public class Relation {
  private String id;
  private String type;
  private Map<String, String> tags;
  private RelationEdge source;
  private RelationEdge target;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public RelationEdge getSource() {
    return source;
  }

  public void setSource(RelationEdge source) {
    this.source = source;
  }

  public RelationEdge getTarget() {
    return target;
  }

  public void setTarget(RelationEdge target) {
    this.target = target;
  }
}
