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

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.item.Element;
import org.amdocs.tsuzammen.commons.datatypes.item.ElementId;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;
import java.util.Collection;

public class ElementImpl implements Element {
  private Id id;
  private Info info;
  private Collection<Relation> relations;
  private Collection<Element> subElements;
  private Collection<ElementId> subElementIds;
  private byte[] data;
  private byte[] searchData;
  private byte[] visualization;

  @Override
  public Id getElementId() {
    return id;
  }

  @Override
  public void setElementId(Id elementId) {
    id = elementId;
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
    return relations;
  }

  @Override
  public void setRelations(Collection<Relation> relations) {
    this.relations = relations;
  }

  @Override
  public InputStream getData() {
    return FileUtils.toInputStream(data);
  }

  @Override
  public void setData(InputStream data) {
    this.data = FileUtils.toByteArray(data);
  }

  @Override
  public InputStream getSearchData() {
    return FileUtils.toInputStream(searchData);
  }

  @Override
  public void setSearchData(InputStream searchData) {
    this.searchData = FileUtils.toByteArray(searchData);
  }

  @Override
  public InputStream getVisualization() {
    return FileUtils.toInputStream(visualization);
  }

  @Override
  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

  @Override
  public Collection<Element> getSubElements() {
    return subElements;
  }

  @Override
  public void setSubElements(Collection<Element> subElements) {
    this.subElements = subElements;
  }

  @Override
  public Collection<ElementId> getSubElementIds() {
    return subElementIds;
  }

  @Override
  public void setSubElementIds(Collection<ElementId> subElementIds) {
    this.subElementIds = subElementIds;
  }
}
