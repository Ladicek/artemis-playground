package cz.ladicek.artemis.amqp.producer;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class Producer {
    @Outgoing("ticks-producer")
    public Multi<Message<String>> produce() {
        return Multi.createFrom()
                .ticks()/*.startingAfter(Duration.ofMillis(2000))*/.every(Duration.ofMillis(1000))
                .map(it -> Message.of("" + it));
    }
}
