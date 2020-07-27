package com.aladdin.cloud.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一接口返回
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResult<T>{
    private int code;
    private String errMsg;
    private  T data;
}

