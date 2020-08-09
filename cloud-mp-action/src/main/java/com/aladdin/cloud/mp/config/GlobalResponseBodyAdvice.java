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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @author lgc
 */
@RestControllerAdvice(basePackages = {"com.aladdin.cloud.mp.web"})
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
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApiResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        String msg = sb.toString();
        return ApiResultBuilder.customerApiResult(HttpStatus.BAD_REQUEST.value(), msg);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApiResult handleConstraintViolationException(ConstraintViolationException ex) {
        return ApiResultBuilder.customerApiResult(ApiErrEnum.CLIENT_ERR.getCode(),ex.getMessage());
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ValidationException.class})
    public ApiResult errorHandler(ValidationException exception){
        exception.printStackTrace();
        return ApiResultBuilder.customerApiResult(ApiErrEnum.CLIENT_ERR.getCode(),exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResult errorHandler(Exception ex) {
        ex.printStackTrace();
        return ApiResultBuilder.error(ApiErrEnum.INTERNAL_ERR);
    }
}