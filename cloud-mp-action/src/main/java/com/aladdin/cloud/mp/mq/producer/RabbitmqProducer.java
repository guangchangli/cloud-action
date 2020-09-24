package com.aladdin.cloud.mp.mq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @author gopher lee
 * @create 2020/9/16 10:39
 */
@Component
public class RabbitmqProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${}")
    private String exchange;
    @Value("${}")
    private String routeKey;

    public String send(Objects obj) {
        Assert.notNull(obj, "message content not null");
        rabbitTemplate.convertAndSend(exchange, routeKey, obj);
        return "";
    }
}
