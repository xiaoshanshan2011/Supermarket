package com.shan.admin.paramsbean;

/**
 * @Author: chenjunshan
 * @Date: 19-1-7 下午4:09
 */
public class ParamsBean {
    private String keyword;//关键词
    private int page;//页码
    private int limit;//页大小

    public String getKeyword() {
        if (keyword == null)
            keyword = "";
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        if (page == 0){
            page = 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        if (limit == 0){
            limit = 10;
        }
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
