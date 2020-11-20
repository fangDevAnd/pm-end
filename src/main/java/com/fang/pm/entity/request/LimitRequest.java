package com.fang.pm.entity.request;

import lombok.Data;

/**
 * 基础版本的 分页请求的bean
 */
@Data
public class LimitRequest implements BaseRequest {

    /**
     * 页面
     */
    private Integer page;

    /**
     * 数量
     */
    private Integer size;


    /**
     * 判断是否存在分页
     *
     * @return
     */
    private boolean hasLimit() {
        if (page != null && size != null) {

            if (size == -1 && page == -1) {
                return false;
            }
            return true;
        }
        return false;
    }


    /**
     * 获得数据存储层的偏移量
     *
     * @return
     */
    public void getLimitAndOffset() {
        if (hasLimit()) {
            page *= size;

        }
    }


}

