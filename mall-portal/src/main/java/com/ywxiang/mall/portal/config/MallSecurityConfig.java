package com.ywxiang.mall.portal.config;

import com.ywxiang.mall.config.SpringSecurityConfig;
import com.ywxiang.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

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
    @Autowired
    private UmsMemberService memberService;

    @Override
    protected UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> memberService.loadUserByUsername(username);
    }
}
