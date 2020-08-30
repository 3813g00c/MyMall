package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类Service
 * @author ywxiang
 * @date 2020/8/30 下午2:59
 */
public interface PmsProductCategoryService {
    /**
     * 以层级显示商品分类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
