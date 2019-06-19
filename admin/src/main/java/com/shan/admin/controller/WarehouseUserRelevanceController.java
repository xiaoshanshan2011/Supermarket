package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.dto.WarehouseUserRelevanceDto;
import com.shan.admin.paramsbean.WarehouseUserRelevanceParamsBean;
import com.shan.admin.service.WarehouseUserRelevanceService;
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
public class WarehouseUserRelevanceController {
	private Logger logger = LoggerFactory.getLogger(WarehouseUserRelevanceController.class);

	@Resource
    private WarehouseUserRelevanceService service;

    @ApiOperation(value = "获取仓库用户关联列表", notes = "获取仓库用户关联列表")
    @GetMapping(value = "/api/admin/selectWarehouseUserRelevance")
    public Result selectWarehouseUserRelevance(@Valid WarehouseUserRelevanceParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }

    @ApiOperation(value = "新增仓库用户关联", notes = "新增仓库用户关联")
    @PostMapping(value = "/api/admin/insertWarehouseUserRelevance")
    public Result insertWarehouseUserRelevance(@Valid WarehouseUserRelevanceDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.insert(dto);
    }

    @ApiOperation(value = "更新仓库用户关联", notes = "更新仓库用户关联")
    @PostMapping(value = "/api/admin/updateWarehouseUserRelevance")
    public Result updateWarehouseUserRelevance(@Valid WarehouseUserRelevanceDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.updateByPrimaryKey(dto);
    }

    @ApiOperation(value = "删除仓库用户关联", notes = "删除仓库用户关联")
    @PostMapping(value = "/api/admin/deleteWarehouseUserRelevance")
    public Result deleteWarehouseUserRelevance(@RequestParam String id){
        return service.deleteByPrimaryKey(id);
    }
}
