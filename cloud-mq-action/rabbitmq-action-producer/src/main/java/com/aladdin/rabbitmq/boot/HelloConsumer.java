package com.aladdin.rabbitmq.boot;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lgc
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "false"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message= " + message);
    }
}
