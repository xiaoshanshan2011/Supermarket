package com.shan.admin.dto;

public class DatagridResult<T> {
    private T rows;
    private long total;

    public DatagridResult(T rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
