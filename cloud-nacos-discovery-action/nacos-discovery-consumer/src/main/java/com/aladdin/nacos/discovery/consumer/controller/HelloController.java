package com.aladdin.nacos.discovery.consumer.controller;

import com.aladdin.nacos.discovery.api.service.HelloDiscoveryService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 */
@RestController
@RequestMapping("consumer")
public class HelloController {

    @Reference
    private HelloDiscoveryService<String> helloDiscoveryService;


    @GetMapping("say")
    public String sayHello() {
        return helloDiscoveryService.helloDiscovery("Aladdin");
    }


}
