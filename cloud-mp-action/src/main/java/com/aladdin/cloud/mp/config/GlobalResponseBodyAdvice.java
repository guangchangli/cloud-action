package com.aladdin.cloud.mp.config;

import com.aladdin.cloud.common.response.ApiErrEnum;
import com.aladdin.cloud.common.response.ApiResult;
import com.aladdin.cloud.common.response.ApiResultBuilder;
import com.aladdin.cloud.common.util.GsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.aladdin.cloud.controller"})
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof ApiResult)) {
            ApiResult ApiResult = new ApiResult(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), o);
            if (o instanceof String) {
                return GsonUtil.toString(ApiResult);
            }
            return ApiResult;
        }
        return o;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResult errorHandler(Exception ex) {
        ex.printStackTrace();
        return ApiResultBuilder.error(ApiErrEnum.INTERNAL_ERR);
    }
}