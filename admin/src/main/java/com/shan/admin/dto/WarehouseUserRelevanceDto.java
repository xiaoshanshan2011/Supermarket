package com.shan.admin.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class WarehouseUserRelevanceDto {
    private String id;

    @NotBlank(message = "userid不能为空")
    private String userid;
    @NotBlank(message = "warehouseid不能为空")
    private String warehouseid;

    private Integer deleted;
    @NotBlank(message = "usertype不能为空")
    private Integer usertype;

    private Date createtime;

    private Date updatetime;

    private WarehouseDto warehouse;

    private WarehouseUserDto warehouseUser;

    public WarehouseUserDto getWarehouseUser() {
        return warehouseUser;
    }

    public void setWarehouseUser(WarehouseUserDto warehouseUser) {
        this.warehouseUser = warehouseUser;
    }

    public WarehouseDto getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDto warehouse) {
        this.warehouse = warehouse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid == null ? null : warehouseid.trim();
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

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
}