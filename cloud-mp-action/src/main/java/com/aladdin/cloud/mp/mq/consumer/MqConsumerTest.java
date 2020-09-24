package com.aladdin.cloud.mp.mq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author gopher lee
 * @create 2020/9/15 23:18
 */
@Component
public class MqConsumerTest {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(
                    name = "gopher",
                    //自动持久化 指定了队列名字默认持久化
                    durable = "true",
                    //自动删除 指定了队列名字 默认不自动删除
                    autoDelete = "false",
                    // 默认不独占
                    exclusive = "true"),
            exchange = @Exchange(name = "boot",
                    durable = "true",
                    type = "topic",
                    ignoreDeclarationExceptions = "true",
                    autoDelete = "false"),
            key = "springboot.#"
    )
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        //	1. 收到消息以后进行业务端消费处理
        System.err.println("-----------------------");
        System.err.println("消费消息:" + message.getPayload());

        //  2. 处理成功之后 获取deliveryTag 并进行手工的ACK操作, 因为我们配置文件里配置的是 手工签收
        //	spring.rabbitmq.listener.simple.acknowledge-mode=manual
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }


}
