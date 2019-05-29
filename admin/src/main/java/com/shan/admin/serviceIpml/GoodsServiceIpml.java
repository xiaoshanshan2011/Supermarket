package com.shan.admin.serviceIpml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.shan.admin.dto.DatagridResult;
import com.shan.admin.dto.GoodsDto;
import com.shan.admin.mapper.GoodsDtoMapper;
import com.shan.admin.paramsbean.GoodsParamsBean;
import com.shan.admin.service.GoodsService;
import com.shan.admin.utils.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceIpml implements GoodsService {
    @Resource
    private GoodsDtoMapper mapper;

    @Override
    public Result selectAll(GoodsParamsBean paramsBean) {
        PageHelper.startPage(paramsBean.getPage(), paramsBean.getLimit());
        paramsBean.setKeyword("%" + paramsBean.getKeyword() + "%");
        List<GoodsDto> list = mapper.selectAll(paramsBean);
        DatagridResult result = new DatagridResult(list,new PageInfo<>(list).getTotal());
        return ResultUtils.success(result);
    }

    @Override
    public Result insert(GoodsDto record) {
        if (record.getBarcode() == null) {
            return ResultUtils.error("barcode字段必传");
        }
        if (TextUtils.isEmpty(record.getGoodsname())) {
            return ResultUtils.error("goodsname字段必传");
        }
//        GoodsDto goodsDto = mapper.selectByPrimaryKeyword(record);
//        if (goodsDto!=null) {
//            return ResultUtils.error("goodscode、barcode、goodsname不能重复创建");
//        }
        record.setDeleted(0);
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        record.setGoodscode(RandomUtils.getGoodsCode(record.getGoodstype()));
        GoodsDto dto = mapper.selectByPrimaryKey(record.getGoodscode());
        if (dto != null) {
            return ResultUtils.error("创建失败");
        }
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(long goodscode) {
        if (goodscode == 0)
            return ResultUtils.error("goodscode字段必传");
        GoodsDto dto = mapper.selectByPrimaryKey(goodscode);
        if (dto == null) {
            return ResultUtils.error("商品不存在");
        }
        dto.setDeleted(1);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(GoodsDto record) {
        if (record.getGoodscode() == null) {
            return ResultUtils.error("goodscode字段必传");
        }
        GoodsDto dto = mapper.selectByPrimaryKey(record.getGoodscode());
        if (dto == null) {
            return ResultUtils.error("商品不存在");
        }
        if (record.getBarcode() != null) {
            dto.setBarcode(record.getBarcode());
        }
        if (!TextUtils.isEmpty(record.getGoodsname())) {
            dto.setGoodsname(record.getGoodsname());
        }
        if (!TextUtils.isEmpty(record.getClassifyid())) {
            dto.setClassifyid(record.getClassifyid());
        }
        if (!TextUtils.isEmpty(record.getGoodsdesc())) {
            dto.setGoodsdesc(record.getGoodsdesc());
        }
        if (!TextUtils.isEmpty(record.getGoodsimg())) {
            dto.setGoodsimg(record.getGoodsimg());
        }
        if (!TextUtils.isEmpty(record.getGoodsspec())) {
            dto.setGoodsspec(record.getGoodsspec());
        }
        if (!TextUtils.isEmpty(record.getGoodsunit())) {
            dto.setGoodsunit(record.getGoodsunit());
        }
        if (!TextUtils.isEmpty(record.getPclassifyid())) {
            dto.setPclassifyid(record.getPclassifyid());
        }
        if (record.getCreatetime() != null) {
            dto.setCreatetime(record.getCreatetime());
        }
        if (record.getDiscountsprice() != null) {
            dto.setDiscountsprice(record.getDiscountsprice());
        }
        if (record.getIshot() != null) {
            dto.setIshot(record.getIshot());
        }
        if (record.getPrice() != null) {
            dto.setPrice(record.getPrice());
        }
        if (record.getVipprice() != null) {
            dto.setVipprice(record.getVipprice());
        }
        if (record.getSpecialsaleprice() != null) {
            dto.setSpecialsaleprice(record.getSpecialsaleprice());
        }
        if (record.getWholesaleprice() != null) {
            dto.setWholesaleprice(record.getWholesaleprice());
        }

        Date date = new Date();
        dto.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
