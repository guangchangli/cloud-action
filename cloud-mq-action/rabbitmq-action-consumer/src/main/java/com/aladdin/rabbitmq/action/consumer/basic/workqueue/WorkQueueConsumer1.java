package com.aladdin.rabbitmq.action.consumer.basic.workqueue;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lgc
 */
public class WorkQueueConsumer1 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        final Channel channel = connection.createChannel();
        //一次消费一个消息，不是全部分配
        channel.basicQos(1);
        channel.queueDeclare("work", true, false, false, null);
        //关闭自动确认
        channel.basicConsume("work", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer-1: " + new String(body));
                //消费一个 手动确认 队列删除 确认标示和 是否开启多个消息同时确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
