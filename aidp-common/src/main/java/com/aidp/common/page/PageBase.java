package com.aidp.common.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 分页对象基类
 * @Author lizhm
 * @Date 2018-12-6 15:33:49
 */
@Data
public abstract class PageBase implements Serializable {

    /**
     * 页号
     */
    private long pageNum = 1;

    /**
     * 页长
     */
    private long pageSize = 10;

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum < 0 ? 1 : pageNum;
    }

}