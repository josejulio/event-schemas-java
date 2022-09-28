package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendations;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class StructuredConsumer {
  Logger log = LoggerFactory.getLogger(StructuredConsumer.class);

  @Inject
  ObjectMapper mapper;

  /*
  NOTE: not using native cloud-event support because:
  - structured cloudevent parsing drops all extensions. TODO: file an issue
  - deserializer generation doesn't handle structured mode. TODO: file an issue
   */
  @Incoming("test-topic-in-structured")
  public Uni<Void> consumeStructured(Message<JsonNode> message) throws JsonProcessingException {
    JsonNode cloudEvent = message.getPayload();
    log.info("Received message for orgId={}", cloudEvent.get("redhatorgid").asText()); // NOSONAR
    AdvisorRecommendations result = mapper.convertValue(cloudEvent.get("data"), AdvisorRecommendations.class);
    log.info("Received message for displayName={}", result.getSystem().getDisplayName());
    return Uni.createFrom().voidItem();
  }
}
