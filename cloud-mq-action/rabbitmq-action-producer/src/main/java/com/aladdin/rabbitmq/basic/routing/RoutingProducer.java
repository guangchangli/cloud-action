package com.aladdin.rabbitmq.basic.routing;

import com.aladdin.rabbitmq.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @author lgc
 */
public class RoutingProducer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 声明交换机和路由
         */
        channel.exchangeDeclare("logs_direct", "direct");
        String routingKey = "error";
        channel.basicPublish("logs_direct",
                routingKey,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                ("direct 模型发布的基于 route key :[" + routingKey + "]").getBytes());
        RabbitmqUtils.closeConnectAndChannel(channel, connection);
    }
}
