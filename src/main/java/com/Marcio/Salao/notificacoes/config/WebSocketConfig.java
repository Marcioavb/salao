package com.Marcio.Salao.notificacoes.config;

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
        // Habilita um broker simples para enviar mensagens aos tópicos
        config.enableSimpleBroker("/topic");
        // Define o prefixo para os endpoints que recebem mensagens dos clientes
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Configura o endpoint WebSocket e habilita o SockJS para fallback
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*") // Permite todas as origens (ajuste para produção)
                .withSockJS(); // Habilita suporte a SockJS para compatibilidade
    }
}
