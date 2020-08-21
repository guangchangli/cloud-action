package com.aladdin.dubbo.provider.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author Gopher lee
 */
@SPI("bumblebee")
public interface Robot {
    void sayHello();
}
