package com.aladdin.cloud.common.response;

import lombok.Getter;

/**
 * @author lgc
 */
@Getter
public class ApiException extends RuntimeException {
    private Integer errCode;
    private String errMsg;

    public ApiException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ApiException(ApiResult<?> responseResult) {
        super(responseResult.getErrMsg());
        this.errCode = responseResult.getCode();
        this.errMsg = responseResult.getErrMsg();
    }

    public ApiException(ApiErrEnum apiErrEnum) {
        super(apiErrEnum.getErrMsg());
        this.errMsg = apiErrEnum.getErrMsg();
        this.errCode = apiErrEnum.getCode();
    }
}
