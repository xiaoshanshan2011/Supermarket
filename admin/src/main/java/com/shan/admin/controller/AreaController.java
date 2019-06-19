package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 区域控制器
 *
 * @Author: chenjunshan
 * @Date: 18-12-29 下午3:48
 */
@Api(tags={"省市区"})
@RestController
public class AreaController {
    @Autowired
    private AreaService service;

    @ApiOperation(value = "获取省市区", notes = "获取省市区")
    @GetMapping(value = "/api/admin/findArea")
    public Result findArea(@RequestParam("parentId") int parentId) {
        return service.selectArea(parentId);
    }
}

