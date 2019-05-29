package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.SysRoleDto;

/**
 * 角色
 */
public interface RoleService {
    Result selectAll();
    Result insert(SysRoleDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(SysRoleDto record);
}
