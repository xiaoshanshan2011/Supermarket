package com.shan.admin.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class WarehouseUserDto {
    private String userid;
    @NotBlank(message = "username不能为空")
    private String username;
    @NotBlank(message = "password不能为空")
    private String password;
    @NotBlank(message = "nickname不能为空")
    private String nickname;
    @NotBlank(message = "mobile不能为空")
    private String mobile;
    @NotNull(message = "provinceid不能为空")
    private Integer provinceid;
    @NotNull(message = "cityid不能为空")
    private Integer cityid;
    @NotNull(message = "districtid不能为空")
    private Integer districtid;
    @NotBlank(message = "address不能为空")
    private String address;

    private Integer deleted;

    private Date createtime;

    private Date updatetime;
    @NotBlank(message = "userphoto不能为空")
    private String userphoto;

    private AreaDto province;
    private AreaDto city;
    private AreaDto district;

    private WarehouseUserRelevanceDto warehouseUserRelevance;

    public WarehouseUserRelevanceDto getWarehouseUserRelevance() {
        return warehouseUserRelevance;
    }

    public void setWarehouseUserRelevance(WarehouseUserRelevanceDto warehouseUserRelevance) {
        this.warehouseUserRelevance = warehouseUserRelevance;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

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

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }
}