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

import org.amdocs.tsuzammen.commons.datatypes.item.Entity;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;
import org.amdocs.tsuzammen.utils.common.CommonMethods;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CoreEntity<T extends Entity> implements Entity {
  private Class<T> implClass;
  private String id;
  private Info info;
  private List<Relation> relations;
  private byte[] data;
  private byte[] visualization;
  private Map<String, Collection<Entity>> contents = new HashMap<>();

  public CoreEntity(){};

  public CoreEntity(T entity, Class<T> entityClass) {
    implClass = entityClass;
    setId(entity.getId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
    setData(entity.getData());
    setVisualization(entity.getVisualization());
    setContents(entity.getContents());
  }

  public CoreEntity(EntityData<T> entity) {
    implClass = entity.getImplClass();
    setId(entity.getId());
    setInfo(entity.getInfo());
    setRelations(entity.getRelations());
    setData(entity.getData());
    setVisualization(entity.getVisualization());
  }

  public T getEntity() {
    T entity = CommonMethods.newInstance(implClass);
    entity.setId(getId());
    entity.setInfo(getInfo());
    entity.setRelations(getRelations());
    entity.setData(getData());
    entity.setVisualization(getVisualization());
    entity.setContents(getContents());
    return entity;
  }

  public Class<T> getImplClass() {
    return implClass;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }


  @Override
  public Map<String, Collection<Entity>> getContents() {
    return contents;
  }

  @Override
  public void setContents(Map<String, Collection<Entity>> contents) {
    this.contents = contents;
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
  public List<Relation> getRelations() {
    return relations;
  }

  @Override
  public void setRelations(List<Relation> relations) {
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

  public InputStream getVisualization() {
    return FileUtils.toInputStream(visualization);
  }

  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

}
