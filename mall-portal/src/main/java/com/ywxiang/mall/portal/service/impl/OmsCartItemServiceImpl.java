package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.mapper.OmsCartItemMapper;
import com.ywxiang.mall.model.OmsCartItem;
import com.ywxiang.mall.portal.dao.PortalProductDao;
import com.ywxiang.mall.portal.domain.CartProduct;
import com.ywxiang.mall.portal.domain.CartPromotionItem;
import com.ywxiang.mall.portal.service.OmsCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车管理Service实现类
 *
 * @author ywxiang
 * @date 2020/12/7 下午8:36
 */
@Service
public class OmsCartItemServiceImpl implements OmsCartItemService {

    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    private PortalProductDao productDao;
//    @Autowired
//    private Oms
    @Override
    public int add(OmsCartItem cartItem) {
        return 0;
    }

    @Override
    public List<OmsCartItem> list(Long memberId) {
        return null;
    }

    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds) {
        return null;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        return 0;
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        return 0;
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return null;
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        return 0;
    }

    @Override
    public int clear(Long memberId) {
        return 0;
    }
}
