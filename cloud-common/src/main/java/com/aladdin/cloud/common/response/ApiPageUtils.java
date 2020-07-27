package com.aladdin.cloud.common.response;


import com.github.pagehelper.PageInfo;

/**
 * @author lgc
 */
public class ApiPageUtils {

    /**
     * 转换分页信息
     * @param pageInfo pageInfo
     * @return pageResponse
     */
    public static PageResponse getPageResult(PageInfo<?> pageInfo) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setPageNum(pageInfo.getPageNum());
        pageResponse.setPageSize(pageInfo.getPageSize());
        pageResponse.setTotalSize(pageInfo.getTotal());
        pageResponse.setTotalPages(pageInfo.getPages());
        pageResponse.setData(pageInfo.getList());
        return pageResponse;
    }
}