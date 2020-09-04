package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.PmsProductAttributeCategoryItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/4 下午8:11
 */
@Repository
public interface PmsProductAttributeCategoryDao {

    /**
     * 获取包含属性的商品分类
     *
     * @return
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
