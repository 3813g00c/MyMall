package com.ywxiang.mall.Controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.component.JwtAuthenticatioToken;
import com.ywxiang.mall.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ywxiang
 * @date 2020/8/8 下午2:04
 */
@RestController
public class LoginControllerTest {
    @Autowired
    private AuthenticationManager authenticationManager;

//    /**
//     * 登录接口
//     */
//    @PostMapping(value = "/login")
//    public CommonResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
//        String username = loginBean.getUsername();
//        String password = loginBean.getPassword();
//
//        // 系统登录认证
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
//
//        return HttpResult.ok(token);
//    }

}
