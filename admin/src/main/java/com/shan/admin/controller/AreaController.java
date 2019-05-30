package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.service.AreaService;
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
@RestController
public class AreaController {
    @Autowired
    private AreaService service;

    @GetMapping(value = "/api/admin/findArea")
    public Result findGroup(@RequestParam("parentId") int parentId) {
        return service.selectArea(parentId);
    }
}

