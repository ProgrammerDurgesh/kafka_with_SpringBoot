package durgeshkafka.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Value("${kafka.common.topic.name}")
    private String topicName;
    //Spring Bean for Kafka Topic
    public NewTopic topic()
    {
        return TopicBuilder.name(topicName).build();//if we provide partition then use it .partitions(3)
    }


}

