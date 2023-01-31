package com.redhat.cloud.event.apps.policies.v1;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

/**
 * A RHEL system managed by console.redhat.com
 */
public class SystemClass {
    private OffsetDateTime checkIn;
    private String displayName;
    private RHELSystemTag[] tags;
    private String hostURL;
    private String hostname;
    private String inventoryID;
    private String rhelVersion;

    /**
     * Timestamp of when the system did a check in. Must adhere to RFC 3339.
     */
    @JsonProperty("check_in")
    public OffsetDateTime getCheckIn() { return checkIn; }
    @JsonProperty("check_in")
    public void setCheckIn(OffsetDateTime value) { this.checkIn = value; }

    @JsonProperty("display_name")
    public String getDisplayName() { return displayName; }
    @JsonProperty("display_name")
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("tags")
    public RHELSystemTag[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(RHELSystemTag[] value) { this.tags = value; }

    @JsonProperty("host_url")
    public String getHostURL() { return hostURL; }
    @JsonProperty("host_url")
    public void setHostURL(String value) { this.hostURL = value; }

    @JsonProperty("hostname")
    public String getHostname() { return hostname; }
    @JsonProperty("hostname")
    public void setHostname(String value) { this.hostname = value; }

    @JsonProperty("inventory_id")
    public String getInventoryID() { return inventoryID; }
    @JsonProperty("inventory_id")
    public void setInventoryID(String value) { this.inventoryID = value; }

    @JsonProperty("rhel_version")
    public String getRHELVersion() { return rhelVersion; }
    @JsonProperty("rhel_version")
    public void setRHELVersion(String value) { this.rhelVersion = value; }
}
