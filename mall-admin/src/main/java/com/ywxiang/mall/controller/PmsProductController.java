package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/list")
    public CommonResult getList(PmsProductQueryParam productQueryParam,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }
}
