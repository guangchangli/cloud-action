package com.aladdin.dubbo.provider.service.spi;

import com.aladdin.dubbo.provider.service.Robot;

public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}

