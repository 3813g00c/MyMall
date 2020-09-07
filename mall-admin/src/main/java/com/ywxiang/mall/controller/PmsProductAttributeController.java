package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.PmsProductAttributeParam;
import com.ywxiang.mall.dto.ProductAttributeInfo;
import com.ywxiang.mall.model.PmsProductAttribute;
import com.ywxiang.mall.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性Controller
 *
 * @author ywxiang
 * @date 2020/9/2 下午9:25
 */
@Api(tags = "商品属性管理")
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    PmsProductAttributeService productAttributeService;

    @ApiOperation("分页获取属性列表")
    @GetMapping("/list/{id}")
    public CommonResult getList(@PathVariable Long id,
                                @RequestParam(value = "type") Integer type,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProductAttribute> productAttributeList = productAttributeService.getList(id, type, pageSize, pageNum);
        return CommonResult.success(productAttributeList);
    }

    @ApiOperation("更新商品属性")
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Long id, @RequestBody PmsProductAttributeParam productAttributeParam) {
        int count = productAttributeService.update(id, productAttributeParam);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("查询单个商品属性")
    @GetMapping("/{id}")
    public CommonResult getItem(@PathVariable Long id) {
        PmsProductAttribute productAttribute = productAttributeService.getItem(id);
        return CommonResult.success(productAttribute);
    }

    @ApiOperation("批量删除商品属性")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = productAttributeService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductAttributeInfo>> getAttrInfo(@PathVariable Long productCategoryId) {
        List<ProductAttributeInfo> productAttrInfoList = productAttributeService.getProductAttributeInfo(productCategoryId);
        return CommonResult.success(productAttrInfoList);
    }
}
