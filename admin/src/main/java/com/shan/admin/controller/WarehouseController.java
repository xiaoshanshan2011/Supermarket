package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.paramsbean.ParamsBean;
import com.shan.admin.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class WarehouseController {
	private Logger logger = LoggerFactory.getLogger(WarehouseController.class);

	@Resource
    private WarehouseService service;
    
    @GetMapping(value = "/api/admin/selectWarehouse")
    public Result selectWarehouse(@Valid ParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }
    @PostMapping(value = "/api/admin/insertWarehouse")
    public Result insertWarehouse(@RequestBody WarehouseDto dto){
        return service.insert(dto);
    }
    @PostMapping(value = "/api/admin/updateWarehouse")
    public Result updateWarehouse(@RequestBody WarehouseDto dto){
        return service.updateByPrimaryKey(dto);
    }
    @PostMapping(value = "/api/admin/deleteWarehouse")
    public Result deleteWarehouse(@RequestParam String warehouseid){
        return service.deleteByPrimaryKey(warehouseid);
    }
}
