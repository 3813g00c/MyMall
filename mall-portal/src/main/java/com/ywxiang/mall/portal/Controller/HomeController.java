package com.ywxiang.mall.portal.Controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.CmsSubject;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductCategory;
import com.ywxiang.mall.portal.domain.HomeContentResult;
import com.ywxiang.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/17 下午9:21
 */
@Api(tags = "首页内容管理")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容页信息展示")
    @GetMapping("/content")
    public CommonResult<HomeContentResult> content() {
        HomeContentResult contentResult = homeService.content();
        return CommonResult.success(contentResult);
    }

    @ApiOperation("分页获取推荐商品")
    @GetMapping("/recommendProductList")
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation("获取首页商品分类")
    @GetMapping("/productCateList/{parentId}")
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation("根据分类获取专题")
    @GetMapping("/subjectList")
    public CommonResult<List<CmsSubject>> getSubjectList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId, pageSize, pageNum);
        return CommonResult.success(subjectList);
    }

    @ApiOperation("获取人气商品")
    @GetMapping("/hotProductList")
    public CommonResult<List<PmsProduct>> hotProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        List<PmsProduct> productList = homeService.hotProductList(pageNum, pageSize);
        return CommonResult.success(productList);
    }

    @ApiOperation("分页获取新品推荐商品")
    @GetMapping("/newProductList")
    public CommonResult<List<PmsProduct>> newProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        List<PmsProduct> productList = homeService.newProductList(pageNum, pageSize);
        return CommonResult.success(productList);
    }
}