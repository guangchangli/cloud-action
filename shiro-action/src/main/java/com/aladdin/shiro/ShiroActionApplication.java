package com.aladdin.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lgc
 */
@SpringBootApplication
@MapperScan({"com.aladdin.shiro.dao"})
public class ShiroActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroActionApplication.class, args);
    }

}
