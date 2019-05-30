package com.shan.admin.mapper;

import com.shan.admin.dto.AreaDto;
import java.util.List;

public interface AreaDtoMapper {
    int deleteByPrimaryKey(Integer areaid);

    int insert(AreaDto record);

    AreaDto selectByPrimaryKey(Integer areaid);

    List<AreaDto> selectAll(Integer parentid);

    int updateByPrimaryKey(AreaDto record);
}