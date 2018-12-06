package com.basic.aidp.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 分页对象
 * @Author lizhm
 * @Date 2018-12-6 15:30:33
 */
@Data
public class Page<T> extends PageBase implements Serializable {

    /**
     * 总数
     */
    private long total;

    /**
     * 上一页页码
     */
    private long prev;

    /**
     * 下一页页码
     */
    private long next;

    /**
     * 第一页页码
     */
    private long first = 1;

    /**
     * 最后一页页码
     */
    private long last;

    /**
     * 显示的页长
     */
    private List<Long> pageList;

    /**
     * 是否第一页
     */
    private boolean firstPage;

    /**
     * 是否最后一页
     */
    private boolean lastPage;

    /**
     * 结果集
     */
    private List<T> result;

    private static final int PAGE_LEN = 5;

    public boolean isFirstPage() {
        return getPageNum() == 1;
    }

    public boolean isLastPage() {
        return (getPageNum() * getPageSize()) - total >= 0;
    }


    public long getPrev() {
        return (getPageNum() - 1) > 0 ? getPageNum() - 1 : 1;
    }

    public long getNext() {
        return getPageNum() + 1 < getLast() ? getPageNum() + 1 : getLast();
    }

    public long getLast() {
        return getTotal() % getPageSize() > 0 ? getTotal() / getPageSize() + 1 : getTotal() / getPageSize();
    }

    public List<Long> getPageList() {

        long start = 1;
        long end = PAGE_LEN;
        List<Long> pageList = new ArrayList<>();

        if (getLast() < PAGE_LEN) {
            end = getLast() + 1;
        }
        else {

            long remainder = getPageNum() % PAGE_LEN;

            if (remainder < PAGE_LEN) {
                if (remainder == 0) {
                    remainder = PAGE_LEN;
                }
                start = getPageNum() - remainder + 1;
            }
            else {
                start = getPageNum() - remainder % PAGE_LEN + 1;
            }
            end = start + PAGE_LEN;

            if (end > getLast()) {
                end = getLast() + 1;
            }
        }

        for (long i = start; i < end; i++) {
            pageList.add(i);
        }

        return pageList;
    }
}