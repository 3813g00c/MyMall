package com.ywxiang.mall.Controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台用户角色管理
 *
 * @author ywxiang
 * @date 2020/8/17 下午9:47
 */
@RestController
@Api(tags = "UmsRoleController", produces = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    UmsRoleService roleService;

    @ApiOperation("获取角色列表")
    @GetMapping("/listAll")
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }
}
