package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.WarehouseDto;
import com.shan.admin.paramsbean.WarehouseParamsBean;
import com.shan.admin.service.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags={"仓库管理"})
@RestController
public class WarehouseController {
	private Logger logger = LoggerFactory.getLogger(WarehouseController.class);

	@Resource
    private WarehouseService service;

    @ApiOperation(value = "获取仓库列表", notes = "获取仓库列表")
    @GetMapping(value = "/api/admin/selectWarehouse")
    public Result selectWarehouse(@Valid WarehouseParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }

    @ApiOperation(value = "创建仓库", notes = "创建仓库")
    @PostMapping(value = "/api/admin/insertWarehouse")
    public Result insertWarehouse(@RequestBody WarehouseDto dto){
        return service.insert(dto);
    }

    @ApiOperation(value = "更新仓库", notes = "更新仓库")
    @PostMapping(value = "/api/admin/updateWarehouse")
    public Result updateWarehouse(@RequestBody WarehouseDto dto){
        return service.updateByPrimaryKey(dto);
    }

    @ApiOperation(value = "删除仓库", notes = "删除仓库")
    @PostMapping(value = "/api/admin/deleteWarehouse")
    public Result deleteWarehouse(@RequestParam String warehouseid){
        return service.deleteByPrimaryKey(warehouseid);
    }
}
