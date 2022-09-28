package org.acme;

import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendations;
import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.ce.OutgoingCloudEventMetadata;
import java.net.URISyntaxException;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class BinaryProducer {
  private static final Logger log = LoggerFactory.getLogger(BinaryProducer.class);

  @Outgoing("test-topic-out")
  public Multi<Message<AdvisorRecommendations>> produce() throws URISyntaxException {
    return Multi.createFrom().range(0, 1).map(x -> {
      AdvisorRecommendations data = MockData.createMockAdvisorRecommendations();

      OutgoingCloudEventMetadata<Object> metadata = MockData.createMockAdvisorCloudEventMetadata();
      log.info("Sending message");
      return Message.of(data).addMetadata(metadata);
    });
  }

}
