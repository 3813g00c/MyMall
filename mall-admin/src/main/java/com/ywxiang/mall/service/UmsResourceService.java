package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsResource;

import java.util.List;

/**
 * 后台资源管理Service
 *
 * @author ywxiang
 * @date 2020/8/11 下午9:06
 */
public interface UmsResourceService {
    /**
     * 查询所有资源
     *
     * @return
     */
    List<UmsResource> listAll();
}
