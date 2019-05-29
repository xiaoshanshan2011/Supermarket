package com.shan.admin.mapper;

import com.shan.admin.dto.SysPrivilegesDto;
import java.util.List;

public interface SysPrivilegesDtoMapper {
    int deleteByPrimaryKey(String privilegesid);

    int insert(SysPrivilegesDto record);

    SysPrivilegesDto selectByPrimaryKey(String privilegesid);

    List<SysPrivilegesDto> selectAll();

    int updateByPrimaryKey(SysPrivilegesDto record);
}