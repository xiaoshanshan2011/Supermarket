package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.HandleUtils;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.publib.utils.UUIDUtils;
import com.shan.admin.dto.SysRoleDto;
import com.shan.admin.mapper.SysRoleDtoMapper;
import com.shan.admin.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceIpml implements RoleService {
    @Resource
    private SysRoleDtoMapper mapper;

    @Override
    public Result selectAll() {
        List<SysRoleDto> list = mapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRolename().equals("admin")) {
                Collections.swap(list,0, i);//互换位置
                break;
            }
        }
        return ResultUtils.success(list);
    }

    @Override
    public Result insert(SysRoleDto record) {
        if (TextUtils.isEmpty(record.getRolename()))
            return ResultUtils.error("rolename必传");
        List<SysRoleDto> dto = mapper.selectByPrimaryName(record.getRolename());
        if (dto != null && dto.size() > 0)
            return ResultUtils.error("角色名称已存在");
        record.setRoleid(UUIDUtils.getNewUid());
        Date date = new Date();
        record.setCreatetime(date);
        record.setUpdatetime(date);
        return HandleUtils.isSuccess(mapper.insert(record));
    }

    @Override
    public Result deleteByPrimaryKey(String roleId) {
        if (TextUtils.isEmpty(roleId))
            return ResultUtils.error("roleId字段必传");
        SysRoleDto dto = mapper.selectByPrimaryKey(roleId);
        if (dto == null) {
            return ResultUtils.error("角色不存在");
        }
        if (dto.getRolename().equals("admin")) {
            return ResultUtils.error("不能删除超级管理员");
        }
        return HandleUtils.isSuccess(mapper.deleteByPrimaryKey(roleId));
    }

    @Override
    public Result updateByPrimaryKey(SysRoleDto record) {
        if (TextUtils.isEmpty(record.getRoleid())) {
            return ResultUtils.error("roleid字段必传");
        }
        if (TextUtils.isEmpty(record.getRolename())) {
            return ResultUtils.error("rolename字段必传");
        }
        SysRoleDto dto = mapper.selectByPrimaryKey(record.getRoleid());
        if (dto.getRolename().equals("admin")) {
            return ResultUtils.error("不能编辑超级管理员");
        }
        if (dto == null) {
            return ResultUtils.error("角色不存在，修改失败");
        } else if (!dto.getRolename().equals(record.getRolename())){
            List<SysRoleDto> list = mapper.selectByPrimaryName(record.getRolename());
            if (list != null && list.size() > 0)
                return ResultUtils.error("角色名称已存在");
        }
        if (!TextUtils.isEmpty(record.getRolename())) {
            dto.setRolename(record.getRolename());
        }
        if (!TextUtils.isEmpty(record.getRoledesc())) {
            dto.setRoledesc(record.getRoledesc());
        }
        dto.setUpdatetime(new Date());
        return HandleUtils.isSuccess(mapper.updateByPrimaryKey(dto));
    }
}
