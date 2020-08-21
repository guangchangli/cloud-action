package com.aladdin.dubbo.provider;

import com.aladdin.dubbo.provider.service.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ServiceLoader;

@SpringBootTest
class DubboProviderApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * java SPI
     *
     * @throws Exception
     */
    @Test
    public void javaSpi() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

    @Test
    public void dubboSpi() {
//        ExtensionLoader<Robot> extensionLoader =
//                ExtensionLoader.getExtensionLoader(Robot.class);
//        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//        optimusPrime.sayHello();
//        Robot bumblebee = extensionLoader.getExtension("bumblebee");
//        bumblebee.sayHello();

        Robot defaultExtension = ExtensionLoader.getExtensionLoader(Robot.class).getDefaultExtension();
        defaultExtension.sayHello();
    }
}
