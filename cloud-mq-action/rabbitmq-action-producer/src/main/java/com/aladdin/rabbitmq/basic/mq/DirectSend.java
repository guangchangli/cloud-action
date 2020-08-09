package com.aladdin.rabbitmq.basic.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 直连 点对点
 * @author lgc
 */
public class DirectSend {

    public static void main(String[] args) {
        sendMessage();
    }

    static void sendMessage() {
        //创建链接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("81.70.30.98");
        connectionFactory.setPort(5672);
        //virtual host
        connectionFactory.setVirtualHost("/cloud-action");
        //username&pass
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = null;
        Channel channel = null;
        try {

            //获取链接对象
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            /**
             * channel bind queue
             * param
             * queue 不存在自动床啊金
             * durable 队列是否持久化
             * exclusive 当前链接是否独占队列
             * autoDelete 消费完成是否自动删除队列
             * arguments 额外参数
             */
            channel.queueDeclare("hello", false, false, false, null);

            /**
             * 发布消息
             * param
             * exchange 交换器
             * 队列
             * 消息额外设置 消息持久化 MessageProperties.PERSISTENT_TEXT_PLAIN
             * 消息的具体内容 byte[]
             */
            channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello,rabbitmq".getBytes());
        } catch (RuntimeException | IOException | TimeoutException ex) {
            ex.printStackTrace();
        } finally {

            try {
                assert channel != null;
                channel.close();
            } catch (IOException | TimeoutException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
