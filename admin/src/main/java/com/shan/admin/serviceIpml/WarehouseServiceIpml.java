package com.shan.admin.serviceIpml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.DatagridResult;
import com.shan.admin.dto.GoodsDto;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.mapper.WarehouseDtoMapper;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.service.WarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WarehouseServiceIpml implements WarehouseService {
    @Resource
    private WarehouseDtoMapper mapper;

    @Override
    public Result selectAll(ParamsBean paramsBean) {
        PageHelper.startPage(paramsBean.getPage(), paramsBean.getLimit());
        paramsBean.setKeyword("%" + paramsBean.getKeyword() + "%");
        List<WarehouseDto> list = mapper.selectAll(paramsBean);
        DatagridResult result = new DatagridResult(list,new PageInfo<>(list).getTotal());
        return ResultUtils.success(result);
    }

    @Override
    public Result insert(WarehouseDto record) {
        if (TextUtils.isEmpty(record.getWarehousename()))
            return ResultUtils.error("warehousename必传");
        WarehouseDto dto = mapper.selectByPrimaryName(record.getWarehousename());
        if (dto != null)
            return ResultUtils.error("仓库名称已存在");
        record.setWarehouseid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String warehouseid) {
        if (TextUtils.isEmpty(warehouseid)) {
            return ResultUtils.error("warehouseid字段必传");
        }
        WarehouseDto dto = mapper.selectByPrimaryKey(warehouseid);
        if (dto == null)
            return ResultUtils.error("删除失败");
        dto.setDeleted(1);
        Date date = new Date();
        dto.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(WarehouseDto record) {
        if (TextUtils.isEmpty(record.getWarehouseid())) {
            return ResultUtils.error("warehouseid字段必传");
        }
        if (TextUtils.isEmpty(record.getWarehousename())) {
            return ResultUtils.error("warehousename字段必传");
        }
        WarehouseDto dto = mapper.selectByPrimaryKey(record.getWarehouseid());
        if (dto == null) {
            return ResultUtils.error("仓库不存在，修改失败");
        } else if (!dto.getWarehousename().equals(record.getWarehousename())){
            WarehouseDto list = mapper.selectByPrimaryName(record.getWarehousename());
            if (list != null)
                return ResultUtils.error("仓库名称已存在");
        }
        if (!TextUtils.isEmpty(record.getWarehousename())) {
            dto.setWarehousename(record.getWarehousename());
        }
        if (!TextUtils.isEmpty(record.getWarehousedesc())) {
            dto.setWarehousedesc(record.getWarehousedesc());
        }
        if (!TextUtils.isEmpty(record.getWarehouseimg())) {
            dto.setWarehouseimg(record.getWarehouseimg());
        }
        if (!TextUtils.isEmpty(record.getWarehousesn())) {
            dto.setWarehousesn(record.getWarehousesn());
        }
        if (!TextUtils.isEmpty(record.getAddress())) {
            dto.setAddress(record.getAddress());
        }
        if (record.getCityid() != null) {
            dto.setCityid(record.getCityid());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
