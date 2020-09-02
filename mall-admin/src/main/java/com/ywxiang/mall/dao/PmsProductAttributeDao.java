package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.ProductAttributeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品属性Dao
 *
 * @author ywxiang
 * @date 2020/9/2 下午9:22
 */
public interface PmsProductAttributeDao {

    /**
     * 获取属性信息
     * @param productCategoryId
     * @return
     */
    List<ProductAttributeInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
