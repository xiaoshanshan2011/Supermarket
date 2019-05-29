package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.paramsbean.ParamsBean;

/**
 * 部门
 */
public interface WarehouseService {
    Result selectAll(ParamsBean paramsBean);
    Result insert(WarehouseDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(WarehouseDto record);
}
