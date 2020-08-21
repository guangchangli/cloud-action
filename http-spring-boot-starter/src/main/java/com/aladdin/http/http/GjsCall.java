package com.aladdin.http.http;

import com.dtflys.forest.annotation.Request;

import java.util.Map;

/**
 * @author lgc
 */
public interface GjsCall {

    @Request(
//            url = "${gjs.url.base}"+"${gjs.url.user}",
            url = "http://10.20.200.102:9002/insure-server/query?apiName=queryCustomerDetailForInsure",
            type = "POST",
//            headers = {"${gjs.url.dataType}"}
            headers = {"Content-type:application/x-www-form-urlencoded"},
            dataType = ""

    )
    String call(
            String apiVersion,
            String saleSystem,
            String clientType,
            String stationId,
            String token,
            String visitorId
    );
//    Map userReqAo(
//            String apiVersion,
//            String saleSystem,
//            String clientType,
//            String stationId,
//            String token,
//            String visitorId
//    );

    @Request(url = "www.baidu.com")
    String sim();

    @Request(
            url = "http://ditu.amap.com/service/regeo?longitude=${0}&latitude=${1}")
    Map getLocation(String longitude, String latitude);
}