package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.SysUserDto;

/**
 * 用户
 */
public interface UserService {
    Result selectAll();
    Result insert(SysUserDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(SysUserDto record);
}
