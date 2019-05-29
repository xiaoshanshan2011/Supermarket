package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.SysUserDto;

import java.util.List;

/**
 * 用户信息接口
 */
public interface LoginService {
    /**
     * 保存user登录信息，返回token
     */
    String generateJwtToken(String uid);
    
    /**
     * 清除token信息
     */
     void deleteLoginInfo(String uid);
    
    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    SysUserDto getUserInfo(String userName);
    SysUserDto getUserInfoByUid(String uid);

    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param uid
     * @return
     */
     List<String> getUserRoles(String uid);

    /**
     * 获取用户信息
     * @return
     */
    Result getUserInfo();

}
