package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.dto.GoodsDto;
import com.shan.admin.paramsbean.GoodsParamsBean;
import com.shan.admin.service.GoodsService;
import io.swagger.annotations.Api;
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

@Api(tags={"平台商品"})
@RestController
public class GoodsController {
	private Logger logger = LoggerFactory.getLogger(GoodsController.class);

	@Resource
    private GoodsService service;
    
    @GetMapping(value = "/api/admin/selectGoods")
    public Result selectGoods(@Valid GoodsParamsBean paramsBean){
        return service.selectAll(paramsBean);
    }
    @PostMapping(value = "/api/admin/insertGoods")
    public Result insertGoods(@Valid GoodsDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.insert(dto);
    }
    @PostMapping(value = "/api/admin/updateGoods")
    public Result updateGoods(@Valid GoodsDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return service.updateByPrimaryKey(dto);
    }
    @PostMapping(value = "/api/admin/deleteGoods")
    public Result deleteGoods(@RequestParam Long goodscode){
        return service.deleteByPrimaryKey(goodscode);
    }
}
