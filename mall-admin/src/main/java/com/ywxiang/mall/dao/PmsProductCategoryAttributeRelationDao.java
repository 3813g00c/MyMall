package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品分类和属性关系Dao
 *
 * @author ywxiang
 * @date 2020/9/1 下午8:47
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * 批量创建
     *
     * @param productCategoryAttributeRelationList
     * @return
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
