package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义商品优惠券与商品分类关系Dao
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:59
 */
@Repository
public interface SmsCouponProductCategoryRelationDao {

    /**
     * 批量创建
     *
     * @param productCategoryRelationList
     * @return
     */
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
