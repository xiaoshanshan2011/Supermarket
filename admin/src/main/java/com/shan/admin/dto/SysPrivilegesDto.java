package com.shan.admin.dto;

import java.util.Date;

public class SysPrivilegesDto {
    private String privilegesid;

    private String privilegesname;

    private String privilegescode;

    private Date createtime;

    private Date updatetime;

    public String getPrivilegesid() {
        return privilegesid;
    }

    public void setPrivilegesid(String privilegesid) {
        this.privilegesid = privilegesid == null ? null : privilegesid.trim();
    }

    public String getPrivilegesname() {
        return privilegesname;
    }

    public void setPrivilegesname(String privilegesname) {
        this.privilegesname = privilegesname == null ? null : privilegesname.trim();
    }

    public String getPrivilegescode() {
        return privilegescode;
    }

    public void setPrivilegescode(String privilegescode) {
        this.privilegescode = privilegescode == null ? null : privilegescode.trim();
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