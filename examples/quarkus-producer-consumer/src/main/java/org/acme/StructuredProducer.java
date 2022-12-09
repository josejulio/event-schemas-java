package org.acme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendations;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.unchecked.Unchecked;
import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class StructuredProducer {
  private static final Logger log = LoggerFactory.getLogger(StructuredProducer.class);

  @Inject
  ObjectMapper mapper;

  @Outgoing("test-topic-out-structured")
  public Multi<Message<AdvisorRecommendations>> produce() {
    return Multi.createFrom().range(0, 1).map(Unchecked.function(x -> {
      AdvisorRecommendations data = MockData.createMockAdvisorRecommendations();

      OutgoingCloudEventMetadata<Object> metadata = MockData.createMockAdvisorCloudEventMetadata();
      log.info("Sending message");
      return Message.of(data).addMetadata(metadata);
    }));
  }
}
