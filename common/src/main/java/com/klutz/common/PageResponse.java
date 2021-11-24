package com.klutz.common;


import java.util.List;

/**
 * created on 2021/11/16
 *
 * @author hejian34
 */
public class PageResponse<T> {

    /**
     * 每页条数
     */
    private Long pageSize;

    /**
     * 页码
     */
    private Long pageIndex;

    /**
     * 是否还有下一页
     */
    private Boolean hasMore;

    /**
     * 总数
     */
    private Long total;

    /**
     * 记录数
     */
    private List<T> records;

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
