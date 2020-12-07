package com.ywxiang.mall.portal.dao;

import com.ywxiang.mall.model.SmsCoupon;
import com.ywxiang.mall.portal.domain.CartProduct;
import com.ywxiang.mall.portal.domain.PromotionProduct;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 *
 * @author ywxiang
 * @date 2020/12/7 下午8:40
 */
@Repository
public interface PortalProductDao {

    /**
     * 获取购物车商品信息
     *
     * @param id
     * @return
     */
    CartProduct getCartProduct(@Param("id") Long id);

    /**
     * 获取促销商品信息列表
     *
     * @param ids
     * @return
     */
    List<PromotionProduct> getPromotionProductList(@org.apache.ibatis.annotations.Param("ids") List<Long> ids);

    /**
     * 获取可用优惠券列表
     *
     * @param productId
     * @param productCategoryId
     * @return
     */
    List<SmsCoupon> getAvailableCouponList(@org.apache.ibatis.annotations.Param("productId") Long productId,
                                           @org.apache.ibatis.annotations.Param("productCategoryId") Long productCategoryId);
}
