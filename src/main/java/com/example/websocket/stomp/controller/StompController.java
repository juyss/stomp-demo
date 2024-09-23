package com.example.websocket.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juyss
 * @version 1.0
 * @description: TODO
 * @date 2024/9/23 10:32
 */
@RestController
public class StompController {

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public String hello(String message) {
        System.out.println("hello处理消息");
        // 处理聊天消息逻辑
        message = "处理后的消息：" + message;
        return message;
    }
    @MessageMapping("/message")
    @SendTo("/topic/message")
    public String message(String message) {
        System.out.println("message处理消息");
        // 处理聊天消息逻辑
        message = "处理后的消息：" + message;
        return message;
    }
}