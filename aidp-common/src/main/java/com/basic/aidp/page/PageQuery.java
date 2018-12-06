package com.basic.aidp.page;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description 分页对象查询器
 * @Author lizhm
 * @Date 2018-12-6 15:31:37
 */
@Data
public class PageQuery<T> extends PageBase implements Serializable {

    /**
     * 查询条件
     */
    @Valid
    @NotNull
    private T query;

    /**
     * 偏移量
     */
    private long offset;

    public long getOffset() {
        return (getPageNum() - 1) * getPageSize();
    }

}