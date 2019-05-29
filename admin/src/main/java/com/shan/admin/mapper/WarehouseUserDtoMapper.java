package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseUserDto;
import java.util.List;

public interface WarehouseUserDtoMapper {
    int deleteByPrimaryKey(String userid);

    int insert(WarehouseUserDto record);

    WarehouseUserDto selectByPrimaryKey(String userid);

    List<WarehouseUserDto> selectAll();

    int updateByPrimaryKey(WarehouseUserDto record);
}