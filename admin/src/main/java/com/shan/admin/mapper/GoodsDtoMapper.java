package com.shan.admin.mapper;

import com.shan.admin.dto.GoodsDto;
import com.shan.admin.paramsbean.GoodsParamsBean;

import java.util.List;

public interface GoodsDtoMapper {
    int deleteByPrimaryKey(Long goodscode);

    int insert(GoodsDto record);

    GoodsDto selectByPrimaryKey(Long goodscode);
    GoodsDto selectByPrimaryKeyword(GoodsDto record);

    List<GoodsDto> selectAll(GoodsParamsBean paramsBean);

    int updateByPrimaryKey(GoodsDto record);
}