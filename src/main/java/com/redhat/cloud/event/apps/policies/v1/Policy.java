package com.redhat.cloud.event.apps.policies.v1;

import com.fasterxml.jackson.annotation.*;

public class Policy {
    private String condition;
    private String description;
    private String id;
    private String name;
    private String url;

    @JsonProperty("condition")
    public String getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(String value) { this.condition = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }
}
