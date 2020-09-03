package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.OssCallbackResult;
import com.ywxiang.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 *
 * @author ywxiang
 * @date 2020/9/3 下午8:36
 */
public interface OssService {

    /**
     * Oss上传策略生成
     *
     * @return
     */
    OssPolicyResult policy();


    /**
     * OSS上传回调
     *
     * @param request
     * @return
     */
    OssCallbackResult callback(HttpServletRequest request);
}
