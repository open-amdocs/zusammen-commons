package org.amdocs.zusammen.commons.health;


import org.amdocs.zusammen.commons.health.data.HealthInfo;

import java.util.Collection;

public interface HealthCheck<Context> {

    Collection<HealthInfo> getHealthStatus(Context context);


}
