package com.ywxiang.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ywxiang
 * @date 2020/8/8 下午2:12
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.ywxiang.mall.mapper", "com.ywxiang.mall.dao"})
public class MallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }
}
