package com.ywxiang.mall.config;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.component.JwtAuthenticationFilter;
import com.ywxiang.mall.component.JwtLoginFilter;
import com.ywxiang.mall.util.JwtTokenUtils;
import com.ywxiang.mall.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * 对SpringSecurity的配置的扩展，支持自定义白名单资源路径和查询用户逻辑
 *
 * @author ywxiang
 * @date 2020/8/8 下午2:00
 */
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        //不需要保护的资源路径允许访问
        for (String url : ignoreUrlsConfig.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated();
        // 退出登录处理器
        http.logout().logoutSuccessHandler((request, response, authentication) -> HttpUtils.write(response, CommonResult.success(null)))
                .logoutUrl("/admin/logout");
        // 开启登录认证流程过滤器
        http.addFilterBefore(jwtLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        // 访问控制时登录状态检查过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    public JwtLoginFilter jwtLoginFilter() throws Exception {
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        jwtLoginFilter.setAuthenticationManager(authenticationManager());
        jwtLoginFilter.setFilterProcessesUrl("/admin/login");
        jwtLoginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    String token = JwtTokenUtils.generateToken(authentication);
                    Map<String, String> tokenMap = new HashMap<>(3);
                    tokenMap.put("token", token);
                    tokenMap.put("tokenHead", tokenHead);
                    HttpUtils.write(response, CommonResult.success(tokenMap));
                }
        );
        jwtLoginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    CommonResult<String> result = CommonResult.failed(exception.getMessage());
                    if (exception instanceof BadCredentialsException) {
                        result.setMessage("用户名或者密码输入错误，请重新输入!");
                    }
                    HttpUtils.write(response, result);
                }
        );
        return jwtLoginFilter;
    }

    /**
     * 加密
     * @return BCryptPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
