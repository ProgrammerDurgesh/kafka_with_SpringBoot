/*
package durgeshkafka.configuration.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Enable a simple in-memory broker with the given destination prefixes
        config.setApplicationDestinationPrefixes("/app"); // Set the application destination prefix
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // UI client will use this to connect to the server
        registry.addEndpoint("/ws-notification")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS();
    }
}
*/
