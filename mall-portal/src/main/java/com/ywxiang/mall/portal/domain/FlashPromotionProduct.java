package com.ywxiang.mall.portal.domain;

import com.ywxiang.mall.model.PmsProduct;

import java.math.BigDecimal;

/**
 * 秒杀信息和商品对象封装
 *
 * @author ywxiang
 * @date 2020/9/16 下午9:55
 */
public class FlashPromotionProduct extends PmsProduct {
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
