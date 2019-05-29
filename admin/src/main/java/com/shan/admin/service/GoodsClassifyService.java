package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.GoodsClassifyDto;

/**
 * 商品分类
 */
public interface GoodsClassifyService {
    Result selectAll(String parentid);
    Result insert(GoodsClassifyDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(GoodsClassifyDto record);
}
