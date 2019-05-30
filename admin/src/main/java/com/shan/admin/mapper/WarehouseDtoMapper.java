package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.paramsbean.ParamsBean;

import java.util.List;

public interface WarehouseDtoMapper {
    int deleteByPrimaryKey(String warehouseid);

    int insert(WarehouseDto record);

    WarehouseDto selectByPrimaryKey(String warehouseid);
    WarehouseDto selectByPrimaryName(String name);
    WarehouseDto selectByPrimarySn(String warehousesn);

    List<WarehouseDto> selectAll(ParamsBean paramsBean);

    int updateByPrimaryKey(WarehouseDto record);
}