package com.shan.admin.dto;

import java.util.Date;

public class WarehouseDto {
    private String warehouseid;

    private String warehousename;

    private String warehouseimg;

    private String warehousesn;

    private Integer cityid;

    private String address;

    private Integer deleted;

    private Date createtime;

    private Date updatetime;

    private String warehousedesc;

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid == null ? null : warehouseid.trim();
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename == null ? null : warehousename.trim();
    }

    public String getWarehouseimg() {
        return warehouseimg;
    }

    public void setWarehouseimg(String warehouseimg) {
        this.warehouseimg = warehouseimg == null ? null : warehouseimg.trim();
    }

    public String getWarehousesn() {
        return warehousesn;
    }

    public void setWarehousesn(String warehousesn) {
        this.warehousesn = warehousesn == null ? null : warehousesn.trim();
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getWarehousedesc() {
        return warehousedesc;
    }

    public void setWarehousedesc(String warehousedesc) {
        this.warehousedesc = warehousedesc == null ? null : warehousedesc.trim();
    }
}