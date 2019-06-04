package com.shan.admin.mapper;

import com.shan.admin.dto.WarehouseUserRelevanceDto;
import com.shan.admin.paramsbean.WarehouseUserRelevanceParamsBean;

import java.util.List;

public interface WarehouseUserRelevanceDtoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WarehouseUserRelevanceDto record);

    WarehouseUserRelevanceDto selectByPrimaryKey(String id);
    WarehouseUserRelevanceDto selectByPrimaryUserid(String userid);

    List<WarehouseUserRelevanceDto> selectAll(WarehouseUserRelevanceParamsBean paramsBean);

    int updateByPrimaryKey(WarehouseUserRelevanceDto record);
}