package com.aladdin.rabbitmq.basic.fanout;

import com.aladdin.rabbitmq.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @author lgc
 */
public class FanoutProducer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();

        /**
         * 通道指定交换机
         * param
         * exchange 交换器模型
         * type 交换器模型
         */
        channel.exchangeDeclare("logs", "fanout");
        channel.basicPublish("logs", "", MessageProperties.PERSISTENT_TEXT_PLAIN, "fanout type message".getBytes());
        RabbitmqUtils.closeConnectAndChannel(channel, connection);
    }
}
