package com.ywxiang.mall.controller;

import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.api.CommonResult;
import com.ywxiang.mall.model.CmsSubject;
import com.ywxiang.mall.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品专题管理Controller
 *
 * @author ywxiang
 * @date 2020/9/5 下午1:18
 */
@Api(tags = "商品专题管理")
@RestController
@RequestMapping("/subject")
public class CmsSubjectController {

    @Autowired
    CmsSubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @GetMapping("/listAll")
    public CommonResult listAll() {
        List<CmsSubject> subjectList = subjectService.listAll();
        return CommonResult.success(subjectList);
    }

    @ApiOperation("分页获取商品专题")
    @PostMapping("/list")
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<CmsSubject> subjectList = subjectService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }
}
