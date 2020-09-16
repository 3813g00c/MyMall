package com.ywxiang.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 前台模块入口
 *
 * @author ywxiang
 * @date 2020/9/16 下午8:51
 */
@SpringBootApplication(scanBasePackages = "com.ywxiang.mall")
public class MallPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallPortalApplication.class, args);
    }
}
