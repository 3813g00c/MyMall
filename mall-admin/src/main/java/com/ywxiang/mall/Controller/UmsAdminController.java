package com.ywxiang.mall.Controller;

import cn.hutool.core.collection.CollUtil;
import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.service.UmsAdminService;
import com.ywxiang.mall.service.UmsRoleService;
import com.ywxiang.mall.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:35
 */
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private UmsRoleService roleService;
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/info")
    public CommonResult getAdminInfo() {
        String username = SecurityUtils.getUsername();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return CommonResult.success(data);
    }
}
