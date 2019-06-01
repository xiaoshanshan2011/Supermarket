package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseUserDto;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.paramsbean.WarehouseUserParamsBean;
import com.shan.admin.service.WarehouseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class WarehouseUserController {
	private Logger logger = LoggerFactory.getLogger(WarehouseUserController.class);

	@Resource
    private WarehouseUserService service;
    
    @GetMapping(value = "/api/admin/selectWarehouseUser")
    public Result selectWarehouseUser(@Valid ParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }
    @PostMapping(value = "/api/admin/insertWarehouseUser")
    public Result insertWarehouseUser(@RequestBody WarehouseUserDto dto){
        return service.insert(dto);
    }
    @PostMapping(value = "/api/admin/updateWarehouseUser")
    public Result updateWarehouseUser(@RequestBody WarehouseUserParamsBean dto){
        return service.updateByPrimaryKey(dto);
    }
    @PostMapping(value = "/api/admin/deleteWarehouseUser")
    public Result deleteWarehouseUser(@RequestParam String userid){
        return service.deleteByPrimaryKey(userid);
    }
}
