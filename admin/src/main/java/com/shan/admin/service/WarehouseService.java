package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.paramsbean.WarehouseParamsBean;

/**
 * 部门
 */
public interface WarehouseService {
    Result selectAll(WarehouseParamsBean paramsBean);
    Result insert(WarehouseDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(WarehouseDto record);
}
