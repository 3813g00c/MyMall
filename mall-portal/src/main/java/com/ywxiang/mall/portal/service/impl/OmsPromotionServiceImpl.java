package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.model.OmsCartItem;
import com.ywxiang.mall.model.PmsSkuStock;
import com.ywxiang.mall.portal.dao.PortalProductDao;
import com.ywxiang.mall.portal.domain.CartPromotionItem;
import com.ywxiang.mall.portal.domain.PromotionProduct;
import com.ywxiang.mall.portal.service.OmsPromotionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 促销管理Service实现类
 *
 * @author ywxiang
 * @date 2020/12/7 下午9:13
 */
@Service
public class OmsPromotionServiceImpl implements OmsPromotionService {
    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {
        // 1.先根据productId对CartItem进行分组，以spu为单位进行计算优惠
        Map<Long, List<OmsCartItem>> productCartMap =
                cartItemList.stream().collect(Collectors.groupingBy(OmsCartItem::getProductId));
        // 2.查询所有商品的优惠相关信息
        List<Long> productIdList = cartItemList.stream().map(OmsCartItem::getProductId).collect(Collectors.toList());
        List<PromotionProduct> promotionProductList = portalProductDao.getPromotionProductList(productIdList);
        // 3.根据商品促销类型计算商品促销优惠价格
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for (Map.Entry<Long, List<OmsCartItem>> entry : productCartMap.entrySet()) {
            Long productId = entry.getKey();
            PromotionProduct promotionProduct = getPromotionProductById(productId, promotionProductList);
            List<OmsCartItem> items = entry.getValue();
            if (promotionProduct != null) {
                Integer promotionType = promotionProduct.getPromotionType();
                if (promotionType == 1) {
                    // 单品促销
                    for (OmsCartItem item : items) {
                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item,cartPromotionItem);
                        cartPromotionItem.setPromotionMessage("单品促销");
                        // 商品原价-促销价
                        PmsSkuStock skuStock = getOriginalPrice(promotionProduct, item.getProductSkuId());
                        assert skuStock != null;
                        BigDecimal originalPrice = skuStock.getPrice();

                    }
                }
            }

        }
        return null;
    }

    /**
     * 根据商品id获取商品促销信息
     *
     * @param productId
     * @param promotionProductList
     * @return
     */
    private PromotionProduct getPromotionProductById(Long productId, List<PromotionProduct> promotionProductList) {
        for (PromotionProduct promotionProduct : promotionProductList) {
            if (productId.equals(promotionProduct.getId())) {
                return promotionProduct;
            }
        }
        return null;
    }

    /**
     * 获取购物车指定商品的数量
     *
     * @param items
     * @return
     */
    private int getCartItemCount(List<OmsCartItem> items) {
        int count = 0;
        for (OmsCartItem item : items) {
            count += item.getQuantity();
        }
        return count;
    }

    /**
     * 获取商品原定价
     *
     * @param promotionProduct
     * @param productSkuId
     * @return
     */
    private PmsSkuStock getOriginalPrice(PromotionProduct promotionProduct, Long productSkuId) {
        for (PmsSkuStock skuStock : promotionProduct.getSkuStockList()) {
            if (productSkuId.equals(skuStock.getId())) {
                return skuStock;
            }
        }
        return null;
    }
}
