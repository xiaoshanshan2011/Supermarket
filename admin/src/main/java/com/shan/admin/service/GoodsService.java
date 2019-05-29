package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.GoodsDto;
import com.shan.admin.paramsbean.GoodsParamsBean;

/**
 * 商品
 */
public interface GoodsService {
    Result selectAll(GoodsParamsBean paramsBean);
    Result insert(GoodsDto record);
    Result deleteByPrimaryKey(long goodscode);
    Result updateByPrimaryKey(GoodsDto record);
}
