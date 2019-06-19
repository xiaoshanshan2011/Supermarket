package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseGoodsDto;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean2;

/**
 * 库存商品
 */
public interface WarehouseGoodsService {
    Result selectAll(WarehouseGoodsParamsBean paramsBean);
    Result insert(WarehouseGoodsDto record);
    Result synchronizedPlatformGoods(String warehouseid);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(WarehouseGoodsParamsBean2 record);
}
