package com.shan.admin.service;


import com.publib.bean.Result;

/**
 * 区域业务接口
 * @Author: chenjunshan
 * @Date: 18-12-30 下午2:30
 */
public interface AreaService {

    //查询省市区
    Result selectArea(int parentId);
}
