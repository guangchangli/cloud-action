package com.aladdin.http;

import com.aladdin.http.http.GjsCall;
import com.dtflys.forest.annotation.ForestScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;



@SpringBootApplication
@RestController
@ForestScan(basePackages = {"com.aladdin.http.http"})
public class HttpSpringBootStarterApplication {
    @Resource
    GjsCall gjsCall;
    @Value("${gjs.url.apiVersion}")
    private String apiVersion;
    @Value("${gjs.url.saleSystem}")
    private String saleSystem;
    @Value("${gjs.url.clientType}")
    private String clientType;
    @Value("${gjs.url.stationId}")
    private String stationId;

    public static void main(String[] args) {
        SpringApplication.run(HttpSpringBootStarterApplication.class, args);
    }

    @GetMapping("login")
    public String callGuoJS(@RequestParam(value = "visitId") String visitId,
                         @RequestParam(value = "token") String token) {
        String webLog = "UserInfoController-callGuoJS 用户登录";
        String result = gjsCall.call(
                "1.0",
                "WMS",
                "06",
                "T10002",
                token,
                visitId
        );
        System.out.println("----------" + result);
        return result;
    }

    @GetMapping("/t")
    public String test() {
        return gjsCall.sim();
    }
    @GetMapping("/g")
    public Map g() {
        return gjsCall.getLocation("121.475078", "31.223577");
    }
}
