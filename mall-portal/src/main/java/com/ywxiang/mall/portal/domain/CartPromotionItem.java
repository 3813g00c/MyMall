package com.ywxiang.mall.portal.domain;

import com.ywxiang.mall.model.OmsCartItem;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 购物车中的促销信息封装
 *
 * @author ywxiang
 * @date 2020/12/7 下午8:20
 */
@Getter
@Setter
public class CartPromotionItem extends OmsCartItem {

    /**
     * 促销活动信息
     */
    private String promotionMessage;

    /**
     * 促销活动减去的金额，针对每个商品
     */
    private BigDecimal reduceAmount;

    /**
     * 商品真实库存（剩余库存减去锁定库存）
     */
    private Integer realStock;

    /**
     * 购买商品赠送积分
     */
    private Integer integration;

    /**
     * 购买商品赠送成长值
     */
    private Integer growth;
}
