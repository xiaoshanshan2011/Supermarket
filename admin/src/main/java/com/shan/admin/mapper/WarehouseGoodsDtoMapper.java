package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseGoodsDto;
import java.util.List;

public interface WarehouseGoodsDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WarehouseGoodsDto record);

    WarehouseGoodsDto selectByPrimaryKey(String id);

    List<WarehouseGoodsDto> selectAll();

    int updateByPrimaryKey(WarehouseGoodsDto record);
}