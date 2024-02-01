package durgeshkafka.controller;

import durgeshkafka.configuration.kafka.Producers;
import durgeshkafka.dto.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private final Producers producers;

    @Autowired
    public KafkaController(Producers producers) {
        this.producers = producers;
    }

    @PostMapping("/send")
    public void sendMessage() {
        NotificationDto notificationDto = new NotificationDto();
        producers.sendMessage("durgesh-topic", "key test", notificationDto.getUrl());
    }
}
