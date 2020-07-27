package com.aladdin.cloud.common.response;

import org.springframework.http.HttpStatus;

/**
 * @author lgc
 */
public enum ApiErrEnum {
    INTERNAL_ERR(501,"系统繁忙"),
    SUCCESS(HttpStatus.OK.value(), "success"),
    ;
    private int code;
    private String errMsg;

    ApiErrEnum(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    ApiErrEnum() {
    }

    public int getCode() {
        return code;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
