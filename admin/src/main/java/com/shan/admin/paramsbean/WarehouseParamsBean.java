package com.shan.admin.paramsbean;

/**
 * @Author: chenjunshan
 * @Date: 19-6-3 下午2:33
 */
public class WarehouseParamsBean extends ParamsBean {
    private Integer provinceid;
    private Integer cityid;
    private Integer districtid;

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }
}
