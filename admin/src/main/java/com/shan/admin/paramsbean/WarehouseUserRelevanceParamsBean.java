package com.shan.admin.paramsbean;

/**
 * @Author: chenjunshan
 * @Date: 19-6-4 下午12:04
 */
public class WarehouseUserRelevanceParamsBean extends ParamsBean {
    private String userid;

    private String warehouseid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid;
    }
}
