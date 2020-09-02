package boot;

import com.aladdin.rabbitmq.RabbitmqActionApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lgc
 */
@SpringBootTest(classes = {RabbitmqActionApplication.class})
@RunWith(SpringRunner.class)
public class TestRabbitMq {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void helloProducer() {
        rabbitTemplate.convertAndSend("hello", "hello-boot-rabbitmq");
    }

    /**
     * work
     */
    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work-boot");
        }
    }

    /**
     * fanout
     */
    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("fanout", "", "fanout test");
    }
    @Test
    public void testRouting(){
        rabbitTemplate.convertAndSend("route","error","info route message");
    }
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("gopher_exchange","gopher.send","gopher say hi");
    }
}
