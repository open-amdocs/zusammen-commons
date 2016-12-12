package org.amdocs.tsuzammen.utils.facade.impl;


import org.amdocs.tsuzammen.utils.common.CommonMethods;
import org.amdocs.tsuzammen.utils.facade.api.FactoriesConfiguration;

import java.util.Map;

public final class FactoryConfig {

  private static final FactoriesConfiguration INSTANCE;

  static {

    try {
      INSTANCE = CommonMethods.newInstance(
          "org.amdocs.tsuzammen.utils.facade.impl.FactoriesConfigImpl", FactoriesConfiguration.class);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public static Map<String, String> getFactoriesMap() {
    return INSTANCE.getFactoriesMap();
  }
}