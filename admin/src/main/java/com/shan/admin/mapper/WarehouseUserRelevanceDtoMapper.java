package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseUserRelevanceDto;
import java.util.List;

public interface WarehouseUserRelevanceDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WarehouseUserRelevanceDto record);

    WarehouseUserRelevanceDto selectByPrimaryKey(String id);

    List<WarehouseUserRelevanceDto> selectAll();

    int updateByPrimaryKey(WarehouseUserRelevanceDto record);
}