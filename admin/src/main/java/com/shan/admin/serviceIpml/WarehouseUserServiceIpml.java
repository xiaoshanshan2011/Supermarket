package com.shan.admin.serviceIpml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.config.shiro.DbShiroRealm;
import com.shan.admin.dto.DatagridResult;
import com.shan.admin.dto.WarehouseUserDto;
import com.shan.admin.mapper.WarehouseUserDtoMapper;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.paramsbean.WarehouseUserParamsBean;
import com.shan.admin.service.WarehouseUserService;
import com.shan.admin.utils.FiledReplaceUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WarehouseUserServiceIpml implements WarehouseUserService {
    @Resource
    private WarehouseUserDtoMapper mapper;

    @Override
    public Result selectAll(ParamsBean paramsBean) {
        PageHelper.startPage(paramsBean.getPage(), paramsBean.getLimit());
        paramsBean.setKeyword("%" + paramsBean.getKeyword() + "%");
        List<WarehouseUserDto> list = mapper.selectAll(paramsBean);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPassword("");
        }
        DatagridResult result = new DatagridResult(list, new PageInfo<>(list).getTotal());
        return ResultUtils.success(result);
    }

    @Override
    public Result insert(WarehouseUserDto record) {
        WarehouseUserDto dto = mapper.selectByPrimaryName(record.getUsername());
        if (dto != null)
            return ResultUtils.error("用户名称已存在");
        WarehouseUserDto dto2 = mapper.selectByPrimaryMobile(record.getMobile());
        if (dto2 != null)
            return ResultUtils.error("手机号码已存在");
        record.setUserid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setDeleted(0);
        record.setCreatetime(date);
        record.setUpdatetime(date);
        String newPassword = new Sha256Hash(String.valueOf(record.getPassword()), DbShiroRealm.encryptSalt).toHex();
        record.setPassword(newPassword);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String userid) {
        if (TextUtils.isEmpty(userid)) {
            return ResultUtils.error("userid字段必传");
        }
        WarehouseUserDto dto = mapper.selectByPrimaryKey(userid);
        if (dto == null)
            return ResultUtils.error("删除失败");
        dto.setDeleted(1);
        Date date = new Date();
        dto.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(WarehouseUserParamsBean record) {
        WarehouseUserDto dto = mapper.selectByPrimaryKey(record.getUserid());
        if (dto == null) {
            return ResultUtils.error("用户不存在，修改失败");
        }
        if (!dto.getUsername().equals(record.getUsername())) {
            WarehouseUserDto dto1 = mapper.selectByPrimaryName(record.getUsername());
            if (dto1 != null)
                return ResultUtils.error("用户名称已存在");
        }
        if (!dto.getMobile().equals(record.getMobile())) {
            WarehouseUserDto dto2 = mapper.selectByPrimaryName(record.getMobile());
            if (dto2 != null)
                return ResultUtils.error("手机号码已存在");
        }
        FiledReplaceUtils.replace(dto, record);
        System.out.println(new Gson().toJson(dto));
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
