package com.aladdin.cloud.mp.web;

import com.aladdin.cloud.common.response.ApiResult;
import com.aladdin.cloud.common.response.ApiResultBuilder;
import com.aladdin.cloud.mp.domain.ao.ValidAo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lgc
 */
@RequestMapping("valid")
@RestController
public class ValidWeb {

    @PutMapping("valid")
    public ApiResult ValidDemo(@RequestBody @Valid ValidAo validAo) {
        return ApiResultBuilder.successWithOutData();
    }

    @PutMapping("Validated")
    public ApiResult ValidatedDemo(@RequestBody @Validated ValidAo validAo) {
        return ApiResultBuilder.successWithOutData();
    }
}
