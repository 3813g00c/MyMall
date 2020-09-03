package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.dto.OssCallbackResult;
import com.ywxiang.mall.dto.OssPolicyResult;
import com.ywxiang.mall.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * OSS相关接口
 *
 * @author ywxiang
 * @date 2020/9/3 下午8:38
 */
@Api(tags = "OSSController", produces = "OSS管理")
@RestController
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    OssService ossService;

    @ApiOperation("OSS上传签名成功")
    @GetMapping("/policy")
    public CommonResult policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation("oss上传成功回调")
    @PostMapping("/callback")
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }
}
