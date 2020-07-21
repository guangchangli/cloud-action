package com.aladdin.naocs.dubbo.provider.service;

import com.aladdin.nacos.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author lgc
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello World "+name;
    }
}
