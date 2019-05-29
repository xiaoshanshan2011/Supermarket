package com.shan.admin.service;

import com.publib.bean.Result;
import com.shan.admin.dto.SysDepartmentDto;

/**
 * 部门
 */
public interface DepartmanrtService {
    Result selectAll();
    Result insert(SysDepartmentDto record);
    Result deleteByPrimaryKey(String id);
    Result updateByPrimaryKey(SysDepartmentDto record);
}
