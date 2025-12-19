package com.ibuu.syncspace.config;

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
        // Enable a simple memory-based message broker
        // Messages sent to "/topic" will be broadcasted to all subscribers
        config.enableSimpleBroker("/topic");

        // Messages sent from client with prefix "/app" will be routed to our controllers
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // This is the URL the Frontend will connect to
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // Allow React (localhost:3000) to connect
                .withSockJS(); // Enable SockJS fallback options
    }
}