package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.PmsProductParam;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/29 下午3:23
 */
@RestController
@Api(tags = "PmsProductController", produces = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    PmsProductService productService;

    @ApiOperation("查询商品")
    @GetMapping("/list")
    public CommonResult getList(PmsProductQueryParam productQueryParam,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("创建商品")
    @PostMapping("/create")
    public CommonResult create(@RequestBody PmsProductParam productParam) {
        int count = productService.create(productParam);
        if (count > 0 ) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
