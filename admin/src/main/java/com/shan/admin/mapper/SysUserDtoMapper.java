package com.shan.admin.mapper;

import com.shan.admin.dto.SysUserDto;
import java.util.List;

public interface SysUserDtoMapper {
    int deleteByPrimaryKey(String userid);

    int insert(SysUserDto record);

    SysUserDto selectByPrimaryKey(String userid);
    SysUserDto selectByPrimaryName(String name);
    SysUserDto selectByPrimaryMobile(String mobile);

    List<SysUserDto> selectAll();

    int updateByPrimaryKey(SysUserDto record);
}