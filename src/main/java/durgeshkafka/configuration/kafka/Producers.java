package durgeshkafka.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Producers {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producers.class);
    private NewTopic topic;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public Producers(NewTopic topic, KafkaTemplate<String, Object> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic,String key,Object object) {
        LOGGER.info(String.format("message event => %s", object.toString()));
        //crete Message
        Message<Object> message = MessageBuilder.withPayload(object).setHeader(KafkaHeaders.TOPIC, "durgesh-topic").build();
        kafkaTemplate.send(message);
    }

}
