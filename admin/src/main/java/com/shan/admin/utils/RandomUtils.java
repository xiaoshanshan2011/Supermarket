package com.shan.admin.utils;

import java.util.UUID;

public class RandomUtils {

    /**
     * 获取商品编号
     * @return
     */
    public static long getGoodsCode(int machineId){
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
//         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return  Long.parseLong(machineId + String.format("%015d", hashCodeV));
    }
}
