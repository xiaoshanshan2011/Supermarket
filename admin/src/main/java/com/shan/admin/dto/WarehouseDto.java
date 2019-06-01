package com.shan.admin.dto;

import java.util.Date;

public class WarehouseDto {
    private String warehouseid;

    private String warehousename;

    private String warehouseimg;

    private String warehousesn;

    private Integer provinceid;
    private Integer cityid;
    private Integer districtid;

    private String address;

    private Integer deleted;

    private Date createtime;

    private Date updatetime;

    private String warehousedesc;

    private AreaDto province;
    private AreaDto city;
    private AreaDto district;

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public AreaDto getProvince() {
        return province;
    }

    public void setProvince(AreaDto province) {
        this.province = province;
    }

    public AreaDto getCity() {
        return city;
    }

    public void setCity(AreaDto city) {
        this.city = city;
    }

    public AreaDto getDistrict() {
        return district;
    }

    public void setDistrict(AreaDto district) {
        this.district = district;
    }

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