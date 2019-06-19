package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.SysDepartmentDto;
import com.shan.admin.service.DepartmanrtService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags={"部门管理"})
@RestController
public class DepartmentController {
	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Resource
    private DepartmanrtService service;
    
    @GetMapping(value = "/api/admin/selectDepartment")
    public Result selectDepartment(){
        return service.selectAll();
    }
    @PostMapping(value = "/api/admin/insertDepartment")
    public Result insertDepartment(@RequestBody SysDepartmentDto dto){
        return service.insert(dto);
    }
    @PostMapping(value = "/api/admin/updateDepartment")
    public Result updateDepartment(@RequestBody SysDepartmentDto dto){
        return service.updateByPrimaryKey(dto);
    }
    @PostMapping(value = "/api/admin/deleteDepartment")
    public Result deleteDepartment(@RequestParam String departmentid){
        return service.deleteByPrimaryKey(departmentid);
    }
}
