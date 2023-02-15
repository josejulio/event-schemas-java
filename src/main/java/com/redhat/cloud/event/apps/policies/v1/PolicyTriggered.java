package com.redhat.cloud.event.apps.policies.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Event data for triggered policies.
 */
public class PolicyTriggered {
    private Policy[] policies;
    private SystemClass system;

    /**
     * Triggered policies for a system
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Policy[] getPolicies() { return policies; }
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setPolicies(Policy[] value) { this.policies = value; }

    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SystemClass getSystem() { return system; }
    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setSystem(SystemClass value) { this.system = value; }
}
