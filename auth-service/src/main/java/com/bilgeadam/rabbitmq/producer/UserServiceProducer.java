package com.bilgeadam.rabbitmq.producer;

import com.bilgeadam.rabbitmq.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Notification notification) {
        rabbitTemplate.convertAndSend("bilgeadam.exchange", "routingKeyCreateUser", notification);
        log.info("notification: {}", notification.toString());
    }
    public void deleteUser(Notification notification) {
        rabbitTemplate.convertAndSend("bilgeadam.exchange", "routingKeyCreateUser", notification);
        log.info("notification: {}", notification.toString());
    }
}
