package com.shan.admin.dto;

public class DatagridResult {
    private Object rows;
    private long total;

    public DatagridResult(Object rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
