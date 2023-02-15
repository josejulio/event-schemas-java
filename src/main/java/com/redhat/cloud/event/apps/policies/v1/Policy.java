package com.redhat.cloud.event.apps.policies.v1;

import com.fasterxml.jackson.annotation.*;

public class Policy {
    private String condition;
    private String description;
    private String id;
    private String name;
    private String url;

    @JsonProperty("condition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCondition() { return condition; }
    @JsonProperty("condition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setCondition(String value) { this.condition = value; }

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getID() { return id; }
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setName(String value) { this.name = value; }

    @JsonProperty("url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getURL() { return url; }
    @JsonProperty("url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setURL(String value) { this.url = value; }
}
