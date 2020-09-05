package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.CmsPrefrenceArea;
import com.ywxiang.mall.service.CmsPreferenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/5 下午1:47
 */
@Api(tags = "CmsPreferenceAreaController", produces = "商品优选管理")
@RestController
@RequestMapping("/prefrenceArea")
public class CmsPreferenceAreaController {
    @Autowired
    CmsPreferenceAreaService preferenceAreaService;

    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    public CommonResult<List<CmsPrefrenceArea>> listAll() {
        List<CmsPrefrenceArea> prefrenceAreaList = preferenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }
}
