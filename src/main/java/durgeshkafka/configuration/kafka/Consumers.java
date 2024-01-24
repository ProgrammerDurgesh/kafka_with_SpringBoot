package durgeshkafka.configuration.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumers {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumers.class);

    @KafkaListener(topics = "${kafka.common.topic.name}", groupId = "${kafka.consumer.group-id}")
    public void consume(Object object) {
        LOGGER.info(String.format("Message Received => %s", object));
        //save message into DB as per requirement
    }
}
