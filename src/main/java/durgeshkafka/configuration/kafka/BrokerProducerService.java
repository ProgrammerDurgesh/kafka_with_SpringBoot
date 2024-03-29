/*
package durgeshkafka.configuration.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class BrokerProducerService {

    private static final Logger log = LoggerFactory.getLogger(BrokerProducerService.class);

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public BrokerProducerService(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        // The KafkaTemplate provides asynchronous send methods returning a Future
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, message);

        // You can register a callback with the listener to receive the result of the send asynchronously
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                log.info("Sent message='{}' with offset={}", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message='{}'", message, ex);
            }
        });
    }
}
*/
