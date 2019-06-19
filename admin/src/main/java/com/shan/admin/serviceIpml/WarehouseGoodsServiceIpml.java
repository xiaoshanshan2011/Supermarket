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
import com.shan.admin.dto.WarehouseGoodsDto;
import com.shan.admin.mapper.GoodsDtoMapper;
import com.shan.admin.mapper.WarehouseDtoMapper;
import com.shan.admin.mapper.WarehouseGoodsDtoMapper;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean2;
import com.shan.admin.service.WarehouseGoodsService;
import com.shan.admin.utils.FiledReplaceUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WarehouseGoodsServiceIpml implements WarehouseGoodsService {
    @Resource
    private WarehouseGoodsDtoMapper mapper;
    @Resource
    private WarehouseDtoMapper warehouseDtoMapper;
    @Resource
    private GoodsDtoMapper goodsDtoMapper;

    @Override
    public Result selectAll(WarehouseGoodsParamsBean paramsBean) {
        if (!TextUtils.isEmpty(paramsBean.getWarehousesn())) {
            WarehouseDto warehouseDto = warehouseDtoMapper.selectByPrimarySn(paramsBean.getWarehousesn());
            if (warehouseDto != null) {
                paramsBean.setWarehouseid(warehouseDto.getWarehouseid());
            }
        }
        PageHelper.startPage(paramsBean.getPage(), paramsBean.getLimit());
        paramsBean.setKeyword("%" + paramsBean.getKeyword() + "%");
        List<WarehouseGoodsDto> list = mapper.selectAll(paramsBean);
        DatagridResult result = new DatagridResult(list, new PageInfo<>(list).getTotal());
        return ResultUtils.success(result);
    }

    @Override
    public Result insert(WarehouseGoodsDto record) {
        WarehouseDto warehouseDto = warehouseDtoMapper.selectByPrimaryKey(record.getWarehouseid());
        if (warehouseDto == null)
            return ResultUtils.error("库存错误");
        GoodsDto goodsDto = goodsDtoMapper.selectByPrimaryKey(record.getGoodscode());
        if (goodsDto == null)
            return ResultUtils.error("商品错误");
        WarehouseGoodsDto dto = mapper.selectByPrimaryWarehouseGoods(record.getWarehouseid(), record.getGoodscode());
        if (dto != null)
            return ResultUtils.error("商品已存在");
        record.setId(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setDeleted(0);
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result synchronizedPlatformGoods(String warehouseid) {
        WarehouseDto warehouseDto = warehouseDtoMapper.selectByPrimaryKey(warehouseid);
        if (warehouseDto == null)
            return ResultUtils.error("库存错误");

        List<GoodsDto> goods = goodsDtoMapper.selectAll();
        for (int i = 0; i < goods.size(); i++) {
            GoodsDto goodsDto = goods.get(i);

            WarehouseGoodsDto dto = mapper.selectByPrimaryWarehouseGoods(warehouseid, goodsDto.getGoodscode());
            if (dto != null)
                continue;

            WarehouseGoodsDto record = new WarehouseGoodsDto();
            record.setGoodscode(goodsDto.getGoodscode());
            record.setPrice(goodsDto.getPrice());
            record.setDiscountsprice(goodsDto.getDiscountsprice());
            record.setSpecialsaleprice(goodsDto.getSpecialsaleprice());
            record.setVipprice(goodsDto.getVipprice());
            record.setWholesaleprice(goodsDto.getWholesaleprice());
            record.setWarehouseid(warehouseid);
            record.setId(UUIDUtils.getNewUid());
            Date date = new Date();
            record.setDeleted(0);
            record.setCreatetime(date);
            record.setUpdatetime(date);
            mapper.insert(record);
        }
        return ResultUtils.successMsg("同步成功");
    }

    @Override
    public Result deleteByPrimaryKey(String id) {
        if (TextUtils.isEmpty(id)) {
            return ResultUtils.error("id字段必传");
        }
        WarehouseGoodsDto dto = mapper.selectByPrimaryKey(id);
        if (dto == null)
            return ResultUtils.error("删除失败");
        dto.setDeleted(1);
        Date date = new Date();
        dto.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(WarehouseGoodsParamsBean2 record) {
        WarehouseGoodsDto dto = mapper.selectByPrimaryKey(record.getId());
        if (dto == null) {
            return ResultUtils.error("商品不存在，修改失败");
        }
        FiledReplaceUtils.replace(dto, record);
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
