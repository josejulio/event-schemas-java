package com.redhat.cloud.event.core.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * An error reported by an application.
 */
public class ErrorClass {
    private String code;
    private String message;
    private Severity severity;
    private String stackTrace;

    /**
     * Machine-readable error code that identifies the error.
     */
    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCode() { return code; }
    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setCode(String value) { this.code = value; }

    /**
     * Human readable description of the error.
     */
    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setMessage(String value) { this.message = value; }

    /**
     * The severity of the error.
     */
    @JsonProperty("severity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Severity getSeverity() { return severity; }
    @JsonProperty("severity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setSeverity(Severity value) { this.severity = value; }

    /**
     * The stack trace/traceback (optional)
     */
    @JsonProperty("stack_trace")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStackTrace() { return stackTrace; }
    @JsonProperty("stack_trace")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setStackTrace(String value) { this.stackTrace = value; }
}
