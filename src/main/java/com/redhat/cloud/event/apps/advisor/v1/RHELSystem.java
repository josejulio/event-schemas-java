package com.redhat.cloud.event.apps.advisor.v1;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

/**
 * A RHEL system managed by console.redhat.com
 */
public class RHELSystem {
    private OffsetDateTime checkIn;
    private String displayName;
    private String hostURL;
    private String hostname;
    private String inventoryID;
    private String rhelVersion;
    private RHELSystemTag[] tags;

    /**
     * Timestamp of when the system did a check in. Must adhere to RFC 3339.
     */
    @JsonProperty("check_in")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OffsetDateTime getCheckIn() { return checkIn; }
    @JsonProperty("check_in")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setCheckIn(OffsetDateTime value) { this.checkIn = value; }

    @JsonProperty("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    @JsonProperty("display_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("host_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getHostURL() { return hostURL; }
    @JsonProperty("host_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setHostURL(String value) { this.hostURL = value; }

    @JsonProperty("hostname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getHostname() { return hostname; }
    @JsonProperty("hostname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setHostname(String value) { this.hostname = value; }

    @JsonProperty("inventory_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInventoryID() { return inventoryID; }
    @JsonProperty("inventory_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setInventoryID(String value) { this.inventoryID = value; }

    @JsonProperty("rhel_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRHELVersion() { return rhelVersion; }
    @JsonProperty("rhel_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRHELVersion(String value) { this.rhelVersion = value; }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public RHELSystemTag[] getTags() { return tags; }
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setTags(RHELSystemTag[] value) { this.tags = value; }
}
