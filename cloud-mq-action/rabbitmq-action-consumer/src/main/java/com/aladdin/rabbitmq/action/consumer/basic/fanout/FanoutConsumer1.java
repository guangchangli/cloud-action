package com.aladdin.rabbitmq.action.consumer.basic.fanout;

import com.aladdin.rabbitmq.action.consumer.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lgc
 */
public class FanoutConsumer1 {
    public static void main(String[] args) throws IOException {

        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 通道绑定交换器
         *
         */
        channel.exchangeDeclare("logs", "fanout");
        //临时队列
        String queueName = channel.queueDeclare().getQueue();
        /**
         * 绑定交换器和队列
         */
        channel.queueBind(queueName, "logs", "");
        /**
         * 消费
         */
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1: " + new String(body));
            }
        });
    }
}
