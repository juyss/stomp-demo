package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author Juyss
 * @version 1.0
 * @description: TODO
 * @date 2024/9/23 10:17
 */

// @EnableWebSocketMessageBroker注解用于开启使用STOMP协议来传输基于代理（MessageBroker）的消息，这时候控制器（controller）
// 开始支持@MessageMapping,就像是使用@requestMapping一样。
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个 Stomp 的节点(endpoint),并指定使用 SockJS 协议。
        registry.addEndpoint("/stomp").withSockJS();
        System.out.println("注册一个 Stomp 的节点(endpoint),并指定使用 SockJS 协议。");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //这里设置了两个简单消息代理的目的地前缀："/topic"用于发布/订阅模式的消息，"/queue"用于点对点的消息传递。
        // 同时，将所有发往"/app"前缀的目的地的消息路由到应用层处理。
        registry.enableSimpleBroker("/topic");
        registry.setUserDestinationPrefix("/user");
        registry.setApplicationDestinationPrefixes("/app");
        System.out.println("/topic用于发布/订阅模式的消息，/queue用于点对点的消息传递。");
    }
}

