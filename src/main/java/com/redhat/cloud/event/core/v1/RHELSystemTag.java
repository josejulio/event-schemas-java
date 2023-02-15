package com.redhat.cloud.event.core.v1;

import com.fasterxml.jackson.annotation.*;

public class RHELSystemTag {
    private String key;
    private String namespace;
    private String value;

    @JsonProperty("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getKey() { return key; }
    @JsonProperty("key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setKey(String value) { this.key = value; }

    @JsonProperty("namespace")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNamespace() { return namespace; }
    @JsonProperty("namespace")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setNamespace(String value) { this.namespace = value; }

    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getValue() { return value; }
    @JsonProperty("value")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setValue(String value) { this.value = value; }
}
