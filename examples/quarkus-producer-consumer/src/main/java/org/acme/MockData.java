package org.acme;

import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendation;
import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendations;
import com.redhat.cloud.event.apps.advisor.v1.RHELSystem;
import com.redhat.cloud.event.apps.advisor.v1.RHELSystemTag;
import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class MockData {

  private MockData() {
    /* intentionally empty */
  }

  protected static OutgoingCloudEventMetadata<Object> createMockAdvisorCloudEventMetadata() {
    return OutgoingCloudEventMetadata.builder()
        .withType("com.redhat.console.advisor.new-recommendations")
        .withSource(URI.create("urn:redhat:source:console:app:advisor"))
        .withId("urn:redhat:console:event:5864ac25-4c52-4c87-bd28-9909a4fa3187")
        .withSubject("urn:redhat:subject:console:rhel:08e8ec2b-6a79-4f1d-bea4-a438da139493")
        .withTimestamp(ZonedDateTime.now())
        .withExtension("redhatorgid", "org123")
        .withExtension("redhatconsolebundle", "rhel")
        .withDataSchema(URI.create("https://console.redhat.com/api/schemas/apps/advisor/v1/advisor-recommendations.json"))
        .build();
  }

  protected static AdvisorRecommendations createMockAdvisorRecommendations() {
    RHELSystemTag tag = new RHELSystemTag();
    tag.setNamespace("insights-client");
    tag.setKey("Environment");
    tag.setValue("Production");

    AdvisorRecommendation recommendation = new AdvisorRecommendation();
    recommendation.setPublishDate(OffsetDateTime.now());
    recommendation.setRebootRequired(false);
    recommendation.setRuleDescription("System is not able to get the latest recommendations and may miss bug fixes when the Insights Client Core egg file is outdated");
    recommendation.setRuleID("insights_core_egg_not_up2date|INSIGHTS_CORE_EGG_NOT_UP2DATE");
    recommendation.setRuleURL("https://console.redhat.com/insights/advisor/recommendations/insights_core_egg_not_up2date|INSIGHTS_CORE_EGG_NOT_UP2DATE/");
    recommendation.setTotalRisk("2");

    RHELSystem system = new RHELSystem();
    system.setDisplayName("rhel8desktop");
    system.setHostname("rhel8desktop");
    system.setHostURL("https://console.redhat.com/insights/inventory/08e8ec2b-6a79-4f1d-bea4-a438da139493");
    system.setRHELVersion("8.3");
    system.setInventoryID("08e8ec2b-6a79-4f1d-bea4-a438da139493");
    system.setTags(new RHELSystemTag[]{tag});

    AdvisorRecommendations data = new AdvisorRecommendations();
    data.setSystem(system);
    data.setAdvisorRecommendations(new AdvisorRecommendation[]{recommendation});
    return data;
  }
}
