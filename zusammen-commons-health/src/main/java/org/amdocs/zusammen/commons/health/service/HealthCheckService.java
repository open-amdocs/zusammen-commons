package org.amdocs.zusammen.commons.health.service;


import org.amdocs.zusammen.commons.health.HealthCheck;
import org.amdocs.zusammen.commons.health.data.HealthInfo;
import org.amdocs.zusammen.commons.log.ZusammenLogger;
import org.amdocs.zusammen.commons.log.ZusammenLoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class HealthCheckService<Context> implements HealthCheck<Context> {

    protected static final ZusammenLogger logger = ZusammenLoggerFactory.getLogger(HealthCheckService.class.getName());

    private String moduleName;

    /**
     * @todo read write lock
     */
    public HealthCheckService(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public Collection<HealthInfo> getHealthStatus ( Context context) {
        List<HealthInfo> healthInfos = new ArrayList<>();
        healthInfos.add(checkHealth(context));
        return  healthInfos;
    }


    protected abstract HealthInfo checkHealth( Context context);

}
