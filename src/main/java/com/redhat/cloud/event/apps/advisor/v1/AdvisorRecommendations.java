package com.redhat.cloud.event.apps.advisor.v1;

import com.fasterxml.jackson.annotation.*;

/**
 * Event data for Advisor Recommendations.
 */
public class AdvisorRecommendations {
    private AdvisorRecommendation[] advisorRecommendations;
    private RHELSystem system;

    /**
     * Advisor recommendations for a system
     */
    @JsonProperty("advisor_recommendations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public AdvisorRecommendation[] getAdvisorRecommendations() { return advisorRecommendations; }
    @JsonProperty("advisor_recommendations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setAdvisorRecommendations(AdvisorRecommendation[] value) { this.advisorRecommendations = value; }

    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public RHELSystem getSystem() { return system; }
    @JsonProperty("system")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setSystem(RHELSystem value) { this.system = value; }
}
