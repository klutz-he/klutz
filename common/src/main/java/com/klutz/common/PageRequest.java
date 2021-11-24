package com.klutz.common;

import javax.validation.constraints.NotNull;

/**
 * created on 2021/11/16
 * @author klutz
 */
public class PageRequest {

    @NotNull(message = "页码不能为空")
    private Integer pageIndex;

    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
