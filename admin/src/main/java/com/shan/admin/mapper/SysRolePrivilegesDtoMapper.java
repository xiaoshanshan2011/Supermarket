package com.shan.admin.mapper;

import com.shan.admin.dto.SysRolePrivilegesDto;
import java.util.List;

public interface SysRolePrivilegesDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRolePrivilegesDto record);

    SysRolePrivilegesDto selectByPrimaryKey(String id);

    List<SysRolePrivilegesDto> selectAll();

    int updateByPrimaryKey(SysRolePrivilegesDto record);
}