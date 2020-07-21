package com.aladdin.nacos.discovery.api.service;

/**
 * @author lgc
 */
public interface HelloDiscoveryService<T> {

    T helloDiscovery(String name);
}
