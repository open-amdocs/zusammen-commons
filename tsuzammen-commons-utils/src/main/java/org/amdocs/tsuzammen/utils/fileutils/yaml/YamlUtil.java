package org.amdocs.tsuzammen.utils.fileutils.yaml;


import org.amdocs.tsuzammen.utils.common.CommonMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.representer.Representer;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class YamlUtil {

  private static Logger logger = LoggerFactory.getLogger(YamlUtil.class);

  public <T> T yamlToObject(String yamlContent, Class<T> tClass) {
    Constructor constructor = getConstructor(tClass);
    constructor.setPropertyUtils(getPropertyUtils());
    TypeDescription yamlFileDescription = new TypeDescription(tClass);
    constructor.addTypeDescription(yamlFileDescription);
    Yaml yaml = new Yaml(constructor);
    T yamlObj = (T) yaml.load(yamlContent);
    return yamlObj;
  }

  public <T> T yamlToObject(InputStream yamlContent, Class<T> tClass) {
    try {
      Constructor constructor = getConstructor(tClass);
      constructor.setPropertyUtils(getPropertyUtils());
      TypeDescription yamlFileDescription = new TypeDescription(tClass);
      constructor.addTypeDescription(yamlFileDescription);
      Yaml yaml = new Yaml(constructor);
      T yamlObj = (T) yaml.load(yamlContent);
      if (yamlObj != null) {
        return yamlObj;
      } else {
        throw new RuntimeException();
      }
    } catch (Exception e) {
      logger.error("Error will trying to convert yaml to object:" + e.getMessage());
      throw new RuntimeException(e);
    } finally {
      try {
        if (yamlContent != null) {
          yamlContent.close();
        }
      } catch (IOException ignore) {
      }
    }
  }


  public <T> Constructor getConstructor(Class<T> tClass) {
    return new StrictMapAppenderConstructor(tClass);
  }

  protected PropertyUtils getPropertyUtils() {
    return new MyPropertyUtils();
  }


  public Map<String, LinkedHashMap<String, Object>> yamlToMap(InputStream yamlContent) {
    return (Map<String, LinkedHashMap<String, Object>>) new Yaml().load(yamlContent);
  }

  public <T> String objectToYaml(Object o) {
    DumperOptions options = new DumperOptions();
    options.setPrettyFlow(true);
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    Representer representer = new CustomRepresenter();
    representer.addClassTag(o.getClass(), Tag.MAP);
    representer.setPropertyUtils(new MyPropertyUtils());

    Yaml yaml = new Yaml(representer, options);
    return yaml.dump(o);
  }

  public InputStream loadYamlFileIS(String yamlFullFileName) {
    return CommonMethods.class.getResourceAsStream(yamlFullFileName);
  }

  public boolean isYamlFileContentValid(String yamlFullFileName) {
    Yaml yaml = new Yaml();
    try {
      Object loadResult = yaml.load(yamlFullFileName);
      return loadResult != null;
    } catch (Exception e) {
      return false;
    }
  }


  private class CustomRepresenter extends Representer {
    @Override
    protected NodeTuple representJavaBeanProperty(Object javaBean, Property property,
                                                  Object propertyValue, Tag customTag) {
      if (propertyValue == null) {
        return null;
      } else {
        NodeTuple defaultNode =
            super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);

        return property.getName().equals("_default")
            ? new NodeTuple(representData("default"), defaultNode.getValueNode())
            : defaultNode;
      }
    }

    @Override
    protected MappingNode representJavaBean(Set<Property> properties, Object javaBean) {
      //remove the bean type from the output yaml (!! ...)
      if (!classTags.containsKey(javaBean.getClass())) {
        addClassTag(javaBean.getClass(), Tag.MAP);
      }

      return super.representJavaBean(properties, javaBean);
    }
  }


  public class MyPropertyUtils extends PropertyUtils {
    @Override
    public Property getProperty(Class<?> type, String name) throws IntrospectionException {
      if (name.equals("default")) {
        name = "_default";
      }
      return super.getProperty(type, name);
    }

    //Unsorted properties
    @Override
    protected Set<Property> createPropertySet(Class<?> type, BeanAccess bAccess)
        throws IntrospectionException {
      return new LinkedHashSet<>(getPropertiesMap(type,
          BeanAccess.FIELD).values());
    }

  }

  protected class StrictMapAppenderConstructor extends Constructor {

    public StrictMapAppenderConstructor(Class<?> theRoot) {
      super(theRoot);
    }

    @Override
    protected Map<Object, Object> constructMapping(MappingNode node) {
      try {
        return super.constructMapping(node);
      } catch (IllegalStateException e) {
        throw new ParserException("while parsing MappingNode", node.getStartMark(), e.getMessage(),
            node.getEndMark());
      }
    }

    @Override
    protected Map<Object, Object> createDefaultMap() {
      final Map<Object, Object> delegate = super.createDefaultMap();
      return new AbstractMap<Object, Object>() {
        @Override
        public Object put(Object key, Object value) {
          if (delegate.containsKey(key)) {
            throw new IllegalStateException("duplicate key: " + key);
          }
          return delegate.put(key, value);
        }

        @Override
        public Set<Entry<Object, Object>> entrySet() {
          return delegate.entrySet();
        }
      };
    }
  }
}



