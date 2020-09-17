package com.ywxiang.mall;

import com.ywxiang.mall.portal.util.DateUtil;

import java.util.Date;

/**
 *
 * @author ywxiang
 * @date 2020/9/17 下午8:35
 */
public class DateUtilTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("*********");
        System.out.println(DateUtil.getDate(date));
        System.out.println(DateUtil.getTime(date));
    }
}
