package com.shan.admin.controller;

import com.publib.bean.Result;
import com.shan.admin.dto.GoodsClassifyDto;
import com.shan.admin.service.GoodsClassifyService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags={"商品分类"})
@RestController
public class GoodsClassfyController {
	private Logger logger = LoggerFactory.getLogger(GoodsClassfyController.class);

	@Resource
    private GoodsClassifyService service;

    @GetMapping(value = "/api/admin/selectGoodsClassify")
    public Result selectGoodsClassify(@RequestParam String parentid){
        return service.selectAll(parentid);
    }

    @PostMapping(value = "/api/admin/insertGoodsClassify")
    public Result insertGoodsClassify(@RequestBody GoodsClassifyDto dto){
        return service.insert(dto);
    }

    @PostMapping(value = "/api/admin/updateGoodsClassify")
    public Result updateGoodsClassify(@RequestBody GoodsClassifyDto dto){
        return service.updateByPrimaryKey(dto);
    }

    @PostMapping(value = "/api/admin/deleteGoodsClassify")
    public Result deleteGoodsClassify(@RequestParam String classifyid){
        return service.deleteByPrimaryKey(classifyid);
    }
}
