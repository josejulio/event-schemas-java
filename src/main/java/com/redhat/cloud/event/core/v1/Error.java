package com.redhat.cloud.event.core.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Event data for an application error.
 */
public class Error {
    private ErrorClass error;

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ErrorClass getError() { return error; }
    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setError(ErrorClass value) { this.error = value; }
}
