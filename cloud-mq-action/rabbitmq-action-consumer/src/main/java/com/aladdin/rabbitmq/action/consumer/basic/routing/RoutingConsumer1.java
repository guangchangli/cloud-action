package com.aladdin.rabbitmq.action.consumer.basic.routing;

import com.aladdin.rabbitmq.action.consumer.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lgc
 */
public class RoutingConsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct", "direct");
        /**
         * 创建临时队列
         */
        String queue = channel.queueDeclare().getQueue();
        /**
         * 基于临时 route key 绑定 队列和交换机
         */
        channel.queueBind(queue, "logs_direct", "info");
        channel.basicQos(1);
        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer 1: " + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }
}
