package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsResourceCategory;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/25 下午10:04
 */
public interface UmsResourceCategoryService {

    /**
     * 获得所有资源分类
     * @return
     */
    List<UmsResourceCategory> listAll();
}
