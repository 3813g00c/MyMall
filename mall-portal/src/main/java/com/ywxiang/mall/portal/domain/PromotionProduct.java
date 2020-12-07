package com.ywxiang.mall.portal.domain;

import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductFullReduction;
import com.ywxiang.mall.model.PmsProductLadder;
import com.ywxiang.mall.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品的促销信息，包括Sku、打折信息、满减优惠
 *
 * @author ywxiang
 * @date 2020/12/7 下午8:42
 */
@Getter
@Setter
public class PromotionProduct extends PmsProduct {

    /**
     * 商品库存信息
     */
    private List<PmsSkuStock> skuStockList;

    /**
     * 商品打折信息
     */
    private List<PmsProductLadder> productLadderList;

    /**
     * 商品满减信息
     */
    private List<PmsProductFullReduction> productFullReductionList;
}
