package com.aladdin.rabbitmq.action.consumer.basic.workqueue;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lgc
 */
public class WorkQueueConsumer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work", true, false, false, null);

        channel.basicConsume("work", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer-2: " + new String(body));
            }
        });
    }
}
