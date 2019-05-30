package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.mapper.AreaDtoMapper;
import com.shan.admin.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 区域业务实现
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaDtoMapper mapper;

    @Override
    public Result selectArea(int parentId) {
        if (parentId == 0)
            return ResultUtils.error("parentId字段必传");
        return ResultUtils.success(mapper.selectAll(parentId));
    }
}
