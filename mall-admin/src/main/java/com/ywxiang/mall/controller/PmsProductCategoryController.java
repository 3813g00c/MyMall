package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;
import com.ywxiang.mall.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类Controller
 * @author ywxiang
 * @date 2020/8/30 下午2:57
 */
@Api(tags = "PmsProductCategoryController", produces = "商品分类管理")
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    PmsProductCategoryService productCategoryService;

    @ApiOperation("查询所有一级分类及其子类")
    @GetMapping("/list/withChildren")
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren() {
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }
}
