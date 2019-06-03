package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.SysDepartmentDto;
import com.shan.admin.mapper.SysDepartmentDtoMapper;
import com.shan.admin.service.DepartmanrtService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DepartmanrtServiceIpml implements DepartmanrtService {
    @Resource
    private SysDepartmentDtoMapper mapper;

    @Override
    public Result selectAll() {
        return ResultUtils.success(mapper.selectAll());
    }

    @Override
    public Result insert(SysDepartmentDto record) {
        if (TextUtils.isEmpty(record.getDepartmentname()))
            return ResultUtils.error("departmentname必传");
        List<SysDepartmentDto> dto = mapper.selectByPrimaryName(record.getDepartmentname());
        if (dto != null && dto.size() > 0)
            return ResultUtils.error("部门名称已存在");
        record.setDepartmentid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String departmentid) {
        if (TextUtils.isEmpty(departmentid)) {
            return ResultUtils.error("departmentid字段必传");
        }
        try {
            return HandleUtils.isSuccess(mapper.deleteByPrimaryKey(departmentid));
        } catch (Exception e) {
            return ResultUtils.error("该部门已被用，删除失败");
        }
    }

    @Override
    public Result updateByPrimaryKey(SysDepartmentDto record) {
        if (TextUtils.isEmpty(record.getDepartmentid())) {
            return ResultUtils.error("departmentid字段必传");
        }
        if (TextUtils.isEmpty(record.getDepartmentname())) {
            return ResultUtils.error("departmentname字段必传");
        }
        SysDepartmentDto dto = mapper.selectByPrimaryKey(record.getDepartmentid());
        if (dto == null) {
            return ResultUtils.error("部门不存在，修改失败");
        } else if (!dto.getDepartmentname().equals(record.getDepartmentname())) {
            List<SysDepartmentDto> list = mapper.selectByPrimaryName(record.getDepartmentname());
            if (list != null && list.size() > 0)
                return ResultUtils.error("部门名称已存在");
        }
        if (!TextUtils.isEmpty(record.getDepartmentname())) {
            dto.setDepartmentname(record.getDepartmentname());
        }
        if (!TextUtils.isEmpty(record.getDepartmentdesc())) {
            dto.setDepartmentdesc(record.getDepartmentdesc());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
