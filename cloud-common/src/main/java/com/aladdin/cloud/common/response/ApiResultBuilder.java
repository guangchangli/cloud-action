package com.aladdin.cloud.common.response;

/**
 * 统一返回 builder
 *
 * @author lgc
 */
public class ApiResultBuilder<T> {

    private static Integer successCode = ApiErrEnum.SUCCESS.getCode();
    private static String successMsg = ApiErrEnum.SUCCESS.getErrMsg();

    /**
     * 不携带数据成功返回
     *
     * @return success
     */
    public static ApiResult<String> successWithOutData() {
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setCode(successCode);
        apiResult.setErrMsg(successMsg);
        apiResult.setData("");
        return apiResult;
    }

    /**
     * 携带数据成功返回
     *
     * @param t   data
     * @param <T> T
     * @return success with data
     */
    public static <T> ApiResult<T> successWithData(T t) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(successCode);
        result.setErrMsg(successMsg);
        result.setData(t);
        return result;
    }

    /**
     * 失败返回errEnum
     *
     * @param apiErrEnum errEnum
     * @param <T>        data
     * @return result
     */
    public static <T> ApiResult<T> error(ApiErrEnum apiErrEnum) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(apiErrEnum.getCode());
        result.setErrMsg(apiErrEnum.getErrMsg());
        return result;
    }

    /**
     * 失败附加错误信息
     *
     * @param apiErrEnum   baseErrEnum
     * @param attachErrMsg attach errMsg
     * @param <T>          data
     * @return result
     */
    public static <T> ApiResult<T> errorWithAttachErrMsg(ApiErrEnum apiErrEnum, String attachErrMsg) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(apiErrEnum.getCode());
        result.setErrMsg(apiErrEnum.getErrMsg() + ":" + attachErrMsg);
        return result;
    }

    /**
     * 重写
     *
     * @param apiErrEnum   apiEnum
     * @param attachErrMsg attachErrMsg
     * @param <T>          data
     * @return result
     */
    public static <T> ApiResult<T> errorOverrideAttachErrMsg(ApiErrEnum apiErrEnum, String attachErrMsg) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(apiErrEnum.getCode());
        result.setErrMsg(attachErrMsg);
        return result;
    }

    /**
     * 重写
     *
     * @param resultCode 返回代码
     * @param resultMsg  返回信息
     * @param <T>        data
     * @return result
     */
    public static <T> ApiResult<T> customerApiResult(int resultCode, String resultMsg) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(resultCode);
        result.setErrMsg(resultMsg);
        return result;
    }

}