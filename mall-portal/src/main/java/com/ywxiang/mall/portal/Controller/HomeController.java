package com.ywxiang.mall.portal.Controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.portal.domain.HomeContentResult;
import com.ywxiang.mall.portal.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
