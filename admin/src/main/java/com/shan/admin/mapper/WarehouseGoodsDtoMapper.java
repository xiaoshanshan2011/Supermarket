package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseGoodsDto;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean;

import java.util.List;

public interface WarehouseGoodsDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WarehouseGoodsDto record);

    WarehouseGoodsDto selectByPrimaryKey(String id);
    WarehouseGoodsDto selectByPrimaryWarehouseGoods(String warehouseid, Long goodscode);

    List<WarehouseGoodsDto> selectAll(WarehouseGoodsParamsBean paramsBean);

    int updateByPrimaryKey(WarehouseGoodsDto record);
}