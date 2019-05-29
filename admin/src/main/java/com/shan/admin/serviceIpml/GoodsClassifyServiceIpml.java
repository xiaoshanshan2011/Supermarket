package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.GoodsClassifyDto;
import com.shan.admin.mapper.GoodsClassifyDtoMapper;
import com.shan.admin.service.GoodsClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class GoodsClassifyServiceIpml implements GoodsClassifyService {
    @Resource
    private GoodsClassifyDtoMapper mapper;

    @Override
    public Result selectAll(String parentid) {
        return ResultUtils.success(mapper.selectAll(parentid));
    }

    @Override
    public Result insert(GoodsClassifyDto record) {
        if (TextUtils.isEmpty(record.getParentid())) {
            record.setParentid("0");
        }
        record.setDeleted(0);
        if (TextUtils.isEmpty(record.getName()))
            return ResultUtils.error("name必传");
        GoodsClassifyDto dto = mapper.selectByPrimaryName(record.getName(),record.getParentid());
        if (dto != null && dto.getDeleted() == 0)
            return ResultUtils.error("商品分类已存在");
        record.setClassifyid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String classifyid) {
        if (TextUtils.isEmpty(classifyid))
            return ResultUtils.error("classifyid字段必传");
        GoodsClassifyDto dto = mapper.selectByPrimaryKey(classifyid);
        if (dto == null) {
            return ResultUtils.error("分类不存在");
        }
        dto.setDeleted(1);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(GoodsClassifyDto record) {
        if (TextUtils.isEmpty(record.getClassifyid())) {
            return ResultUtils.error("classifyid字段必传");
        }
        if (TextUtils.isEmpty(record.getName())) {
            return ResultUtils.error("name字段必传");
        }
        GoodsClassifyDto dto = mapper.selectByPrimaryKey(record.getClassifyid());
        if (dto == null) {
            return ResultUtils.error("分类不存在，修改失败");
        } else if (!dto.getName().equals(record.getName())){
            GoodsClassifyDto dto1 = mapper.selectByPrimaryName(record.getName(), record.getParentid());
            if (dto1 != null)
                return ResultUtils.error("分类已存在");
        }
        if (!TextUtils.isEmpty(record.getName())) {
            dto.setName(record.getName());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
