package com.redhat.cloud.event.core.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Event data for a RHEL system.
 */
public class RHELSystem {
    private SystemClass system;

    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SystemClass getSystem() { return system; }
    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setSystem(SystemClass value) { this.system = value; }
}
