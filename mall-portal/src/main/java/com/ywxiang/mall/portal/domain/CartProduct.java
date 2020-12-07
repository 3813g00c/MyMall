package com.ywxiang.mall.portal.domain;

import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductAttribute;
import com.ywxiang.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 购物车中选择规格的商品信息
 *
 * @author ywxiang
 * @date 2020/12/7 下午8:28
 */
@Getter
@Setter
public class CartProduct extends PmsProduct {
    /**
     * 商品属性列表
     */
    private List<PmsProductAttribute> productAttributeList;

    /**
     * 库存列表
     */
    private List<PmsSkuStock> skuStockList;
}
