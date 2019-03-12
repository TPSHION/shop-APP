package com.stm.shop.utils;

import java.util.Date;

/**
 * @Author：飞鸿
 * @Description：时间工具类
 * @Date：Created on 21:29 2018/12/27.
 * @ModifyBy：
 */
public class DateUtil {

    /**
    * @author 飞鸿
    * @Description 获取十位数的时间戳
    * @Date 21:30 2018/12/27
    * @MethodName getSecondTimestamp
    * @param date
    * @return int
    **/
    public static int getSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0,length-3));
        } else {
            return 0;
        }
    }
}
