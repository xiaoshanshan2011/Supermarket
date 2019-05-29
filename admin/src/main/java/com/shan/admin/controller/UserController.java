package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.SysUserDto;
import com.shan.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
    private UserService service;
    
    @GetMapping(value = "/api/admin/selectUser")
    public Result selectUser(){
        return service.selectAll();
    }
    
    @PostMapping(value = "/api/admin/insertUser")
    public Result insertUser(@RequestBody SysUserDto dto){
        return service.insert(dto);
    }
    
    @PostMapping(value = "/api/admin/updateUser")
    public Result updateUser(@RequestBody SysUserDto dto){
        return service.updateByPrimaryKey(dto);
    }
    
    @PostMapping(value = "/api/admin/deleteUser")
    public Result deleteUser(@RequestParam String userId){
        return service.deleteByPrimaryKey(userId);
    }
}
