package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.item.Format;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;

import java.util.List;

public class EntityData {
  private Info info;
  private Object data;
  private Format dataFormat;
  private Object visualization;
  private List<Relation> relations;

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

  public Format getDataFormat() {
    return dataFormat;
  }

  public void setDataFormat(Format dataFormat) {
    this.dataFormat = dataFormat;
  }

  public Object getVisualization() {
    return visualization;
  }

  public void setVisualization(Object visualization) {
    this.visualization = visualization;
  }

  public List<Relation> getRelations() {
    return relations;
  }

  public void setRelations(
      List<Relation> relations) {
    this.relations = relations;
  }
}
