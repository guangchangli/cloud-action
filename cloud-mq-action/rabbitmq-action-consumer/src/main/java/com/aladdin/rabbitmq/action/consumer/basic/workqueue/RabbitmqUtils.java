package com.aladdin.rabbitmq.action.consumer.basic.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Properties;

/**
 * @author lgc
 */
public class RabbitmqUtils {
    private static ConnectionFactory connectionFactory;
    static {
        connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("81.70.30.98");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/cloud-action");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
    }

    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnectAndChannel(Channel channel,Connection connection){
        try {
            assert channel!=null;
            channel.close();
            assert connection!=null;
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
