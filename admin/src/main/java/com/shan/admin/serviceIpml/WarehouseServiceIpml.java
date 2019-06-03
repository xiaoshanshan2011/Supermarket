package com.shan.admin.serviceIpml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.DatagridResult;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.mapper.WarehouseDtoMapper;
import com.shan.admin.paramsbean.WarehouseParamsBean;
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
    public Result selectAll(WarehouseParamsBean paramsBean) {
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
        if (TextUtils.isEmpty(record.getWarehousesn()))
            return ResultUtils.error("warehousesn必传");
        if (TextUtils.isEmpty(record.getWarehouseimg()))
            return ResultUtils.error("warehouseimg必传");
        if (record.getCityid() == null)
            return ResultUtils.error("cityid必传");
        if (TextUtils.isEmpty(record.getAddress()))
            return ResultUtils.error("address必传");
        WarehouseDto dto = mapper.selectByPrimaryName(record.getWarehousename());
        if (dto != null)
            return ResultUtils.error("仓库名称已存在");
        WarehouseDto dto2 = mapper.selectByPrimarySn(record.getWarehousesn());
        if (dto2 != null)
            return ResultUtils.error("仓库编号已存在");
        record.setWarehouseid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setDeleted(0);
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
        if (TextUtils.isEmpty(record.getWarehousesn())) {
            return ResultUtils.error("warehousesn字段必传");
        }
        WarehouseDto dto = mapper.selectByPrimaryKey(record.getWarehouseid());
        if (dto == null) {
            return ResultUtils.error("仓库不存在，修改失败");
        }
        if (!dto.getWarehousename().equals(record.getWarehousename())){
            WarehouseDto dto1 = mapper.selectByPrimaryName(record.getWarehousename());
            if (dto1 != null)
                return ResultUtils.error("仓库名称已存在");
        }
        if (!dto.getWarehousesn().equals(record.getWarehousesn())){
            WarehouseDto dto2 = mapper.selectByPrimaryName(record.getWarehousesn());
            if (dto2 != null)
                return ResultUtils.error("仓库编号已存在");
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
        if (record.getProvinceid() != null) {
            dto.setProvinceid(record.getProvinceid());
        }
        if (record.getCityid() != null) {
            dto.setCityid(record.getCityid());
        }
        if (record.getDistrictid() != null) {
            dto.setDistrictid(record.getDistrictid());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
