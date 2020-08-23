package com.ywxiang.mall.Controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.UmsMenuNode;
import com.ywxiang.mall.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/23 下午8:20
 */
@Api(tags = "UmsMenuController", produces = "后台菜单管理")
@RequestMapping("/menu")
@RestController
public class UmsMenuController {

    @Autowired
    private UmsMenuService menuService;

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }
}
