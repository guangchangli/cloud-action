package com.aladdin.rabbitmq.action.consumer.basic.topic;

import com.aladdin.rabbitmq.action.consumer.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lgc
 */
public class TopicConsumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 声明交换器以及交换器类型
         */
        channel.exchangeDeclare("topics", "topic");
        String queue = channel.queueDeclare().getQueue();
        /**
         * 创建临时队列,绑定队列和交换机,routingKey
         */
        channel.queueBind(queue, "topics", "user.*");
        channel.basicQos(1);
        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer 1 : " + new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
