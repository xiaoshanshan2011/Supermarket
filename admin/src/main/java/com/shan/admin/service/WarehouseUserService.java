package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseUserDto;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.paramsbean.WarehouseUserParamsBean;

/**
 * 库存用户
 */
public interface WarehouseUserService {
    Result selectAll(ParamsBean paramsBean);
    Result insert(WarehouseUserDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(WarehouseUserParamsBean record);
}
