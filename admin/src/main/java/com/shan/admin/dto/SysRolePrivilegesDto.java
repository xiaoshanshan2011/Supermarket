package com.shan.admin.dto;

import java.util.Date;

public class SysRolePrivilegesDto {
    private String id;

    private String privilegesid;

    private String roleid;

    private Date createtime;

    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPrivilegesid() {
        return privilegesid;
    }

    public void setPrivilegesid(String privilegesid) {
        this.privilegesid = privilegesid == null ? null : privilegesid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
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
}