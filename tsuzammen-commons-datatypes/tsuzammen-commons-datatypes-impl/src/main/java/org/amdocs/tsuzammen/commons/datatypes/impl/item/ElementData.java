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

import org.amdocs.tsuzammen.commons.datatypes.item.Element;
import org.amdocs.tsuzammen.utils.common.CommonMethods;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;

public class ElementData extends ElementInfo {
  private Class<? extends Element> implClass;
  private byte[] data;
  private byte[] searchData;
  private byte[] visualization;

  // used by collaboration-store on get operations
  public ElementData() {

  }

  // used by core on save operations
  public ElementData(Element element) {
    super(element);
    setImplClass(element.getClass());
    setData(element.getData());
    setSearchData(element.getSearchData());
    setVisualization(element.getVisualization());
  }

  // used by core on get operations
  public Element getElement() {
    Element element = CommonMethods.newInstance(implClass);
    element.setElementId(getElementId().getId());
    element.setInfo(getElementId().getInfo());
    element.setRelations(getRelations());
    element.setSubElementIds(getSubElementIds());
    element.setData(getData());
    element.setSearchData(getSearchData());
    element.setVisualization(getVisualization());
    return element;
  }

  public Class<? extends Element> getImplClass() {
    return implClass;
  }

  public void setImplClass(Class<? extends Element> implClass) {
    this.implClass = implClass;
  }

  public InputStream getData() {
    return FileUtils.toInputStream(data);
  }

  public void setData(InputStream data) {
    this.data = FileUtils.toByteArray(data);
  }

  public InputStream getSearchData() {
    return FileUtils.toInputStream(searchData);
  }

  public void setSearchData(InputStream searchData) {
    this.searchData = FileUtils.toByteArray(searchData);
  }

  public InputStream getVisualization() {
    return FileUtils.toInputStream(visualization);
  }

  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

}
