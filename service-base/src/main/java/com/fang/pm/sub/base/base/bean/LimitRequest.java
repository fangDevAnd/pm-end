package com.fang.pm.sub.base.base.bean;


/**
 * 基础版本的 分页请求的bean
 */
public class LimitRequest implements BaseRequest {

    /**
     * 页面
     */
    private Integer page;

    /**
     * 数量
     */
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

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

