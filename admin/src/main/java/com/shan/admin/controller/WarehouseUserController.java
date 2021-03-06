package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.dto.WarehouseUserDto;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.paramsbean.WarehouseUserParamsBean;
import com.shan.admin.service.WarehouseUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags={"仓库管理"})
@RestController
public class WarehouseUserController {
	private Logger logger = LoggerFactory.getLogger(WarehouseUserController.class);

	@Resource
    private WarehouseUserService service;

    @ApiOperation(value = "获取仓库用户列表", notes = "获取仓库用户列表")
    @GetMapping(value = "/api/admin/selectWarehouseUser")
    public Result selectWarehouseUser(@Valid ParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }

    @ApiOperation(value = "创建仓库用户", notes = "创建仓库用户")
    @PostMapping(value = "/api/admin/insertWarehouseUser")
    public Result insertWarehouseUser(@Valid WarehouseUserDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.insert(dto);
    }

    @ApiOperation(value = "更新仓库用户", notes = "更新仓库用户")
    @PostMapping(value = "/api/admin/updateWarehouseUser")
    public Result updateWarehouseUser(@Valid WarehouseUserParamsBean dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.updateByPrimaryKey(dto);
    }

    @ApiOperation(value = "删除仓库用户", notes = "删除仓库用户")
    @PostMapping(value = "/api/admin/deleteWarehouseUser")
    public Result deleteWarehouseUser(@RequestParam String userid){
        return service.deleteByPrimaryKey(userid);
    }
}
