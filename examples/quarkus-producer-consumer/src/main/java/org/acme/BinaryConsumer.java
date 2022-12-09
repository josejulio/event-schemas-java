package org.acme;

import com.redhat.cloud.event.apps.advisor.v1.AdvisorRecommendations;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.impl.ce.DefaultIncomingKafkaCloudEventMetadata;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class BinaryConsumer {
  Logger log = LoggerFactory.getLogger(BinaryConsumer.class);

  @Incoming("test-topic-in")
  public Uni<Void> consume(Message<AdvisorRecommendations> message) {
    // NOTE: should use IncomingKafkaCloudEventMetadata per https://quarkus.io/blog/kafka-cloud-events/#consuming-cloud-event-from-kafka TODO: file an issue
    var metadata = message.getMetadata().get(DefaultIncomingKafkaCloudEventMetadata.class).orElseThrow();
    log.info("Received message for orgId={}", metadata.getExtension("redhatorgid").orElseThrow());
    log.info("Received message for displayName={}", message.getPayload().getSystem().getDisplayName());
    return Uni.createFrom().voidItem();
  }
}
