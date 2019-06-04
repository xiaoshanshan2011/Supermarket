package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.WarehouseUserRelevanceDto;
import com.shan.admin.mapper.WarehouseUserRelevanceDtoMapper;
import com.shan.admin.paramsbean.WarehouseUserRelevanceParamsBean;
import com.shan.admin.service.WarehouseUserRelevanceService;
import com.shan.admin.utils.FiledReplaceUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WarehouseUserRelevanceServiceIpml implements WarehouseUserRelevanceService {
    @Resource
    private WarehouseUserRelevanceDtoMapper mapper;

    @Override
    public Result selectAll(WarehouseUserRelevanceParamsBean paramsBean) {
        List<WarehouseUserRelevanceDto> list = mapper.selectAll(paramsBean);
        return ResultUtils.success(list);
    }

    @Override
    public Result insert(WarehouseUserRelevanceDto record) {
        WarehouseUserRelevanceDto dto = mapper.selectByPrimaryUserid(record.getUserid());
        if (dto != null)
            return ResultUtils.error("用户已存在");
        record.setId(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setDeleted(0);
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String id) {
        if (TextUtils.isEmpty(id)) {
            return ResultUtils.error("id字段必传");
        }
        WarehouseUserRelevanceDto dto = mapper.selectByPrimaryKey(id);
        if (dto == null)
            return ResultUtils.error("删除失败");
        dto.setDeleted(1);
        Date date = new Date();
        dto.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(WarehouseUserRelevanceDto record) {
        WarehouseUserRelevanceDto dto = mapper.selectByPrimaryKey(record.getId());
        if (dto == null) {
            return ResultUtils.error("用户不存在，修改失败");
        }
        FiledReplaceUtils.replace(dto, record);
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
