/*
 * Copyright © 2016 Amdocs Software Systems Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.amdocs.tsuzammen.commons.datatypes.impl.item;

import org.amdocs.tsuzammen.commons.datatypes.item.Format;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class EntityData {
  private Info info;
  private byte[] data;
  private Format dataFormat;
  private byte[] visualization;
  private List<Relation> relations;

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public InputStream getData() {
    if(this.data==null) return new ByteArrayInputStream(new byte[]{});
    ByteArrayInputStream is = new ByteArrayInputStream(this.data);
    return is;
  }

  public void setData(InputStream data) {
    this.data = FileUtils.toByteArray(data);
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public Format getDataFormat() {
    return dataFormat;
  }

  public void setDataFormat(Format dataFormat) {
    this.dataFormat = dataFormat;
  }

  public InputStream getVisualization() {
    if(this.visualization==null) return new ByteArrayInputStream(new byte[]{});
    ByteArrayInputStream is = new ByteArrayInputStream(this.visualization);
    return is;
  }

  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

  public void setVisualization(byte[] visualization) {
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
