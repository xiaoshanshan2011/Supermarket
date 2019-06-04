package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseUserRelevanceDto;
import com.shan.admin.paramsbean.WarehouseUserRelevanceParamsBean;

/**
 * 库存用户
 */
public interface WarehouseUserRelevanceService {
    Result selectAll(WarehouseUserRelevanceParamsBean paramsBean);
    Result insert(WarehouseUserRelevanceDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(WarehouseUserRelevanceDto record);
}
