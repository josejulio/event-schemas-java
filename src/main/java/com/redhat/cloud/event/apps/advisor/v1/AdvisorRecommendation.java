package com.redhat.cloud.event.apps.advisor.v1;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class AdvisorRecommendation {
    private OffsetDateTime publishDate;
    private boolean rebootRequired;
    private String ruleDescription;
    private String ruleID;
    private String ruleURL;
    private String totalRisk;

    @JsonProperty("publish_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OffsetDateTime getPublishDate() { return publishDate; }
    @JsonProperty("publish_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setPublishDate(OffsetDateTime value) { this.publishDate = value; }

    @JsonProperty("reboot_required")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public boolean getRebootRequired() { return rebootRequired; }
    @JsonProperty("reboot_required")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRebootRequired(boolean value) { this.rebootRequired = value; }

    @JsonProperty("rule_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRuleDescription() { return ruleDescription; }
    @JsonProperty("rule_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRuleDescription(String value) { this.ruleDescription = value; }

    @JsonProperty("rule_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRuleID() { return ruleID; }
    @JsonProperty("rule_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRuleID(String value) { this.ruleID = value; }

    @JsonProperty("rule_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRuleURL() { return ruleURL; }
    @JsonProperty("rule_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setRuleURL(String value) { this.ruleURL = value; }

    @JsonProperty("total_risk")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTotalRisk() { return totalRisk; }
    @JsonProperty("total_risk")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setTotalRisk(String value) { this.totalRisk = value; }
}
