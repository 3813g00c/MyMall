package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 自定义商品分类Dao
 *
 * @author ywxiang
 * @date 2020/8/30 下午3:04
 */
public interface PmsProductCategoryDao {

    /**
     * 获取商品分类以及其子类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
