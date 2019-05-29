package com.shan.admin.dto;

import java.util.Date;

public class SysDepartmentDto {
    private String departmentid;

    private String departmentname;

    private String departmentdesc;

    private Date createtime;

    private Date updatetime;

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getDepartmentdesc() {
        return departmentdesc;
    }

    public void setDepartmentdesc(String departmentdesc) {
        this.departmentdesc = departmentdesc == null ? null : departmentdesc.trim();
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