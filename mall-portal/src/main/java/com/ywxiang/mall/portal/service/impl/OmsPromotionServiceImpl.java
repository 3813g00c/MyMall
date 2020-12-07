package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.model.OmsCartItem;
import com.ywxiang.mall.portal.dao.PortalProductDao;
import com.ywxiang.mall.portal.domain.CartPromotionItem;
import com.ywxiang.mall.portal.domain.PromotionProduct;
import com.ywxiang.mall.portal.service.OmsPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return null;
    }
}
