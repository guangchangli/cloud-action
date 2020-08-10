package com.aladdin.cloud.mp.web;

import com.aladdin.cloud.common.response.ApiResult;
import com.aladdin.cloud.common.response.ApiResultBuilder;
import com.aladdin.cloud.mp.domain.ao.InnerValidListAo;
import com.aladdin.cloud.mp.domain.ao.ValidAo;
import com.aladdin.cloud.mp.domain.ao.ValidationList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lgc
 */
@RequestMapping("valid")
@RestController
public class ValidWeb {

    @PutMapping("save")
    public ApiResult save(@RequestBody @Validated(ValidAo.GroupA.class) ValidAo validAo) {
        return ApiResultBuilder.successWithOutData();
    }
    @PostMapping("update")
    public ApiResult update(@RequestBody @Validated(ValidAo.GroupB.class) ValidAo validAo) {
        return ApiResultBuilder.successWithOutData();
    }

    @PostMapping("validList")
    public ApiResult ValidatedDemo(@RequestBody @Validated ValidationList<InnerValidListAo> validListAos) {
        return ApiResultBuilder.successWithOutData();
    }
}
