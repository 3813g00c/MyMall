package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.model.OmsCartItem;
import com.ywxiang.mall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * 促销管理Service
 * @author ywxiang
 * @date 2020/12/7 下午9:09
 */
public interface OmsPromotionService {

    /**
     * 计算购物车促销活动信息
     * @param cartItemList
     * @return
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
