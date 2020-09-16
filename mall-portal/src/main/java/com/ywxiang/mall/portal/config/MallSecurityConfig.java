package com.ywxiang.mall.portal.config;

import com.ywxiang.mall.config.SpringSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 前台模块Security配置类
 *
 * @author ywxiang
 * @date 2020/9/16 下午9:18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig extends SpringSecurityConfig {
}
