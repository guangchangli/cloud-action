package com.aladdin.rabbitmq.boot;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lgc
 */
@Component
public class FanoutConsumer {

    /**
     * 临时队列交换机
     *
     * @param message
     */
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, exchange = @Exchange(value = "fanout", type = "fanout"))
    })
    public void fanout1(String message) {
        System.out.println("message1: " + message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, exchange = @Exchange(value = "fanout", type = "fanout"))
    })
    public void fanout2(String message) {
        System.out.println("message2: " + message);
    }
}
