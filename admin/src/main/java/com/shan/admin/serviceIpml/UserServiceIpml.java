package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.config.shiro.DbShiroRealm;
import com.shan.admin.dto.SysUserDto;
import com.shan.admin.mapper.SysUserDtoMapper;
import com.shan.admin.service.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceIpml implements UserService {
    @Resource
    private SysUserDtoMapper mapper;

    @Override
    public Result selectAll() {
        List<SysUserDto> list = mapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPassword(null);
        }
        return ResultUtils.success(list);
    }

    @Override
    public Result insert(SysUserDto record) {
        if (TextUtils.isEmpty(record.getDepartmentid()))
            return ResultUtils.error("departmentid字段必传");
        if (TextUtils.isEmpty(record.getUsername()))
            return ResultUtils.error("username字段必传");
        if (TextUtils.isEmpty(record.getPassword()))
            return ResultUtils.error("password字段必传");
        if (TextUtils.isEmpty(record.getMobile()))
            return ResultUtils.error("mobile字段必传");
        SysUserDto dto = mapper.selectByPrimaryName(record.getUsername());
        SysUserDto dto2 = mapper.selectByPrimaryMobile(record.getMobile());
        if (dto != null){
            return ResultUtils.error("用户已存在");
        }
        if (dto2 != null)
            return ResultUtils.error("手机号码已存在");
        record.setUserid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        String newPassword = new Sha256Hash(String.valueOf(record.getPassword()), DbShiroRealm.encryptSalt).toHex();
        record.setPassword(newPassword);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String userId) {
        if (TextUtils.isEmpty(userId))
            return ResultUtils.error("userId字段必传");
        SysUserDto dto = mapper.selectByPrimaryKey(userId);
        if (dto == null) {
            return ResultUtils.error("用户不存在");
        }
        dto.setDeleted(1);
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }

    @Override
    public Result updateByPrimaryKey(SysUserDto record) {
        if (TextUtils.isEmpty(record.getUserid())) {
            return ResultUtils.error("userid字段必传");
        }
        if (TextUtils.isEmpty(record.getUsername())) {
            return ResultUtils.error("username字段必传");
        }
        SysUserDto dto = mapper.selectByPrimaryKey(record.getUserid());
        if (dto == null) {
            return ResultUtils.error("用户不存在，修改失败");
        } else if (!dto.getUsername().equals(record.getUsername())){
            SysUserDto sysUserDto = mapper.selectByPrimaryName(record.getUsername());
            if (sysUserDto != null)
                return ResultUtils.error("用户已存在");
        } else if (!dto.getMobile().equals(record.getMobile())){
            SysUserDto sysUserDto = mapper.selectByPrimaryMobile(record.getMobile());
            if (sysUserDto != null)
                return ResultUtils.error("手机号码已存在");
        }
        if (!TextUtils.isEmpty(record.getUsername())) {
            dto.setUsername(record.getUsername());
        }
        if (!TextUtils.isEmpty(record.getPassword())) {
            dto.setPassword(record.getPassword());
        }
        if (!TextUtils.isEmpty(record.getDepartmentid())) {
            dto.setDepartmentid(record.getDepartmentid());
        }
        if (!TextUtils.isEmpty(record.getRoleid())) {
            dto.setRoleid(record.getRoleid());
        }
        if (!TextUtils.isEmpty(record.getMobile())) {
            dto.setMobile(record.getMobile());
        }
        if (!TextUtils.isEmpty(record.getEmail())) {
            dto.setEmail(record.getEmail());
        }
        if (!TextUtils.isEmpty(record.getNickname())) {
            dto.setNickname(record.getNickname());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
