package com.ywxiang.mall.Controller;

import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.service.UmsRoleService;
import io.lettuce.core.Value;
import io.lettuce.core.cluster.pubsub.api.sync.PubSubNodeSelection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("分页获取角色列表")
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsRole> roleList = roleService.listByPage(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @PostMapping("/updateStatus/{id}")
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        int count = roleService.update(id, umsRole);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
