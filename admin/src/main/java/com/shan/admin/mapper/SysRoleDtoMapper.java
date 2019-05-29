package com.shan.admin.mapper;

import com.shan.admin.dto.SysRoleDto;
import java.util.List;

public interface SysRoleDtoMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(SysRoleDto record);

    SysRoleDto selectByPrimaryKey(String roleid);
    List<SysRoleDto> selectByPrimaryName(String name);

    List<SysRoleDto> selectAll();

    int updateByPrimaryKey(SysRoleDto record);
}