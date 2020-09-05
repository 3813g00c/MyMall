package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义优惠券和商品关系关系Dao
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:56
 */
@Repository
public interface SmsCouponProductRelationDao {

    /**
     * 批量创建优惠卷与商品关系
     *
     * @param productRelationList
     * @return
     */
    int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
