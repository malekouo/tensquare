package com.tensquare.entity;

import java.util.*;

//分页封装
public class PageResult<T> {

    private long total;
    private List<T> rows;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}
