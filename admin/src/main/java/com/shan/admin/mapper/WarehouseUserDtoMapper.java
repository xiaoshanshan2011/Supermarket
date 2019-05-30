package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseUserDto;
import com.shan.admin.paramsbean.ParamsBean;

import java.util.List;

public interface WarehouseUserDtoMapper {
    int deleteByPrimaryKey(String userid);

    int insert(WarehouseUserDto record);

    WarehouseUserDto selectByPrimaryKey(String userid);
    WarehouseUserDto selectByPrimaryName(String username);
    WarehouseUserDto selectByPrimaryMobile(String mobile);

    List<WarehouseUserDto> selectAll(ParamsBean paramsBean);

    int updateByPrimaryKey(WarehouseUserDto record);
}