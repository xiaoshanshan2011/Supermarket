package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.dto.WarehouseGoodsDto;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean;
import com.shan.admin.paramsbean.WarehouseGoodsParamsBean2;
import com.shan.admin.service.WarehouseGoodsService;
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

@Api(tags={"仓库库存管理"})
@RestController
public class WarehouseGoodsController {
	private Logger logger = LoggerFactory.getLogger(WarehouseGoodsController.class);

	@Resource
    private WarehouseGoodsService service;

    @ApiOperation(value = "获取仓库存库商品列表", notes = "获取仓库存库商品列表")
    @GetMapping(value = "/api/admin/selectWarehouseGoods")
    public Result<WarehouseGoodsDto> selectWarehouseGoods(@Valid WarehouseGoodsParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }

    @ApiOperation(value = "新增仓库存库商品", notes = "新增仓库存库商品")
    @PostMapping(value = "/api/admin/insertWarehouseGoods")
    public Result insertWarehouseGoods(@Valid WarehouseGoodsDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.insert(dto);
    }

    @ApiOperation(value = "更新仓库存库商品", notes = "更新仓库存库商品")
    @PostMapping(value = "/api/admin/updateWarehouseGoods")
    public Result updateWarehouseGoods(@Valid WarehouseGoodsParamsBean2 dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.updateByPrimaryKey(dto);
    }

    @ApiOperation(value = "删除仓库存库商品", notes = "删除仓库存库商品")
    @PostMapping(value = "/api/admin/deleteWarehouseGoods")
    public Result deleteWarehouseGoods(@RequestParam String id){
        return service.deleteByPrimaryKey(id);
    }

    @ApiOperation(value = "同步平台商品", notes = "同步平台商品")
    @PostMapping(value = "/api/admin/synchronizedPlatformGoods")
    public Result synchronizedPlatformGoods(@RequestParam String warehouseid){
        return service.synchronizedPlatformGoods(warehouseid);
    }
}
