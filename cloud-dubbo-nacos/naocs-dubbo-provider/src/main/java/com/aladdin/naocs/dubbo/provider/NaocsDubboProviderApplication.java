package com.aladdin.naocs.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class NaocsDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaocsDubboProviderApplication.class, args);
    }

}
