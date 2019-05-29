package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.SysRoleDto;
import com.shan.admin.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class RoleController {
	private Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Resource
    private RoleService service;
    
    @GetMapping(value = "/api/admin/selectRole")
    public Result selectRole(){
        return service.selectAll();
    }
    
    @PostMapping(value = "/api/admin/insertRole")
    public Result insertRole(@RequestBody SysRoleDto dto){
        return service.insert(dto);
    }
    
    @PostMapping(value = "/api/admin/updateRole")
    public Result updateRole(@RequestBody SysRoleDto dto){
        return service.updateByPrimaryKey(dto);
    }
    
    @PostMapping(value = "/api/admin/deleteRole")
    public Result deleteRole(@RequestParam String roleId){
        return service.deleteByPrimaryKey(roleId);
    }
}
