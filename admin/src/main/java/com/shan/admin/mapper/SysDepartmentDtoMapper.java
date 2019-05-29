package com.shan.admin.mapper;

import com.shan.admin.dto.SysDepartmentDto;
import java.util.List;

public interface SysDepartmentDtoMapper {
    int deleteByPrimaryKey(String departmentid);

    int insert(SysDepartmentDto record);

    SysDepartmentDto selectByPrimaryKey(String departmentid);
    List<SysDepartmentDto> selectByPrimaryName(String name);

    List<SysDepartmentDto> selectAll();

    int updateByPrimaryKey(SysDepartmentDto record);
}