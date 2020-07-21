package com.aladdin.nacos.discovery.provider.service;

import com.aladdin.nacos.discovery.api.service.HelloDiscoveryService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lgc
 */
@Service
public class NacosDiscoveryService<T> implements HelloDiscoveryService<T> {
    @Override
    public T helloDiscovery(String name) {
        return (T) ("Hello Nacos Discovery " + name);
    }
}
