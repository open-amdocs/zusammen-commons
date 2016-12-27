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

import org.amdocs.tsuzammen.commons.datatypes.item.Content;
import org.amdocs.tsuzammen.commons.datatypes.item.Element;
import org.amdocs.tsuzammen.commons.datatypes.item.Entity;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;
import org.amdocs.tsuzammen.utils.common.CommonMethods;

import java.util.Collection;
import java.util.Map;

public class CoreEntity<T extends Entity> extends EntityData implements Entity {
  private Map<String, Content> contents;

  public CoreEntity() {
  }

  public CoreEntity(T entity, Class<T> entityClass) {
    setImplClass(entityClass);
    setElementId(entity.getElementId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
    setData(entity.getData());
    setSearchData(entity.getSearchData());
    setVisualization(entity.getVisualization());
    setContents(entity.getContents());
  }

  public CoreEntity(EntityInfo entity) {
    setElementId(entity.getElementId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
    setContentIds(getContentIds());
  }

  public CoreEntity(EntityData<T> entity) {
    this((EntityInfo) entity);
    setImplClass(entity.getImplClass());
    setData(entity.getData());
    setSearchData(entity.getSearchData());
    setVisualization(entity.getVisualization());
  }

  public T getEntity() {
    T entity = (T) CommonMethods.newInstance(getImplClass());
    entity.setElementId(getElementId());
    entity.setInfo(getInfo());
    entity.setRelations(getRelations());
    entity.setData(getData());
    entity.setSearchData(getSearchData());
    entity.setVisualization(getVisualization());
    entity.setContents(getContents());
    return entity;
  }

  @Override
  public Map<String, Content> getContents() {
    return contents;
  }

  @Override
  public void setContents(Map<String, Content> contents) {
    this.contents = contents;
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
}
