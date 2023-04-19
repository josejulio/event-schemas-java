package com.redhat.cloud.event.apps.repositories.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Event data for Repository Events.
 */
public class RepositoryEvents {
    private Repositories[] repositories;

    /**
     * List of repositories affected by the event
     */
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Repositories[] getRepositories() { return repositories; }
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRepositories(Repositories[] value) { this.repositories = value; }
}
