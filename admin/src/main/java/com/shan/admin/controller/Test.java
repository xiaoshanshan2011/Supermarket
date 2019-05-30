package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.dto.TestBean;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class Test {
    @GetMapping("/image/test")
    public String test() {
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
//         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    @PostMapping("/image/test2")
    public Result test2(@Valid TestBean bean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                return ResultUtils.error(error.getDefaultMessage());
            }
        }
        return ResultUtils.successMsg("成功");
    }
}
