package com.publib.utils;


import com.enums.ResultEnum;
import com.publib.bean.Result;

/**
 * @Author: chenjunshan
 * @Date: 19-1-3 下午6:23
 */
public class HandleUtils {

    /**
     * 是否操作成功
     * @param status
     * @return
     */
    public static Result isSuccess(int status){
        if (status == 1) {
            return ResultUtils.success();
        } else {
            return ResultUtils.error(ResultEnum.REQUEST_ERROR.getCode(), "请求失败");
        }
    }
}
