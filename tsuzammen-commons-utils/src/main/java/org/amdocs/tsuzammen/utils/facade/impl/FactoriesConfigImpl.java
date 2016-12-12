package org.amdocs.tsuzammen.utils.facade.impl;


import org.amdocs.tsuzammen.utils.facade.api.FactoriesConfiguration;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;
import org.amdocs.tsuzammen.utils.fileutils.json.JsonUtil;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FactoriesConfigImpl implements FactoriesConfiguration {


  private static final String FACTORY_CONFIG_FILE_NAME = "factoryConfiguration.json";
  private static Map factoryMap = new HashMap();
  private static boolean initialized = false;

  @SuppressWarnings("unchecked")
  public Map<String, String> getFactoriesMap() {
    synchronized (this) {
      if (!initialized) {
        init();
        initialized = true;
      }
    }
    return factoryMap;
  }

  private void init() {
    List<InputStream> factoryConfigISList = FileUtils.getFileInputStreams(FACTORY_CONFIG_FILE_NAME);
    for (InputStream factoryConfigIS : factoryConfigISList) {
      factoryMap.putAll(JsonUtil.json2Object(factoryConfigIS, Map.class));
    }
  }


}

