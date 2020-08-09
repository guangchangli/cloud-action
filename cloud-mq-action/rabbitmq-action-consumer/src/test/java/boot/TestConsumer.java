package boot;

import com.aladdin.rabbitmq.action.consumer.RabbitmqActionConsumerApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lgc
 */
@SpringBootTest(classes = {RabbitmqActionConsumerApplication.class})
@RunWith(SpringRunner.class)
public class TestConsumer {

    public void testHello() {

    }
}
