package com.aladdin.rabbitmq.action.consumer.boot;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lgc
 */
@Component
//监听队列
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloConsumer {

    @RabbitListener
    public void receive(String message) {
        System.out.println("message= " + message);
    }
}
