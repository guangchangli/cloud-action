package com.aladdin.rabbitmq.action.consumer.basic.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费端回调一直在监听 新开了线程
 * @author lgc
 */
public class DirectConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        directConsumer();
    }
    static void directConsumer() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("81.70.30.98");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/cloud-action");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);

        /**
         * 消费消息
         * param
         * queue 队列
         * autoAck
         * consumer CallBack
         */
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            /**
             *
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body 消息队列中取出的消息
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("---------------"+new String(body));
            }
        });
    }
}
