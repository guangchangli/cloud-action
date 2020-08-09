package com.aladdin.rabbitmq.basic.topic;

import com.aladdin.rabbitmq.basic.workqueue.RabbitmqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * @author lgc
 */
public class TopicProvider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", "topic");
        String routingKey = "user.save";
        channel.basicPublish("topics",
                routingKey,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                ("routing topic message,routeKey: [" + routingKey + "]").getBytes());
        RabbitmqUtils.closeConnectAndChannel(channel, connection);
    }
}
