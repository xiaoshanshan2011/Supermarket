package com.shan.admin.mapper;

import com.shan.admin.dto.GoodsClassifyDto;
import java.util.List;

public interface GoodsClassifyDtoMapper {
    int deleteByPrimaryKey(String classifyid);

    int insert(GoodsClassifyDto record);

    GoodsClassifyDto selectByPrimaryKey(String classifyid);
    GoodsClassifyDto selectByPrimaryName(String name,String parentid);

    List<GoodsClassifyDto> selectAll(String parentid);

    int updateByPrimaryKey(GoodsClassifyDto record);
}