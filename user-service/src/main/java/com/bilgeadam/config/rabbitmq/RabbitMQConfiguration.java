package com.bilgeadam.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    // Exchange name:
    private String exchangeName = "bilgeadam.exchange";

    // Routing ve QueueName eşlemeşme için kullanılır:
    private final String routingKeyCreateUser = "routingKeyCreateUser";
    private String queueNameCreateUser = "queueCreateUser";

    @Bean
    Queue queue() {
        return new Queue(queueNameCreateUser);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(routingKeyCreateUser);
    }

    public Binding binding(final Queue queue, final DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingKeyCreateUser);
    }
}
