package org.amdocs.tsuzammen.commons.datatypes.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TALIG on 11/28/2016.
 */
public class  Content {

  private Format dataFormat;
  private List<Entity> entities = new ArrayList<>();
  public Format getDataFormat() {
    return dataFormat;
  }

  public void setDataFormat(Format dataFormat) {
    this.dataFormat = dataFormat;
  }

  public List<Entity> getEntities() {
    return entities;
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }
}
