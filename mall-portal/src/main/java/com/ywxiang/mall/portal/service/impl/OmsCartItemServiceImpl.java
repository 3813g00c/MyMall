package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.mapper.OmsCartItemMapper;
import com.ywxiang.mall.model.OmsCartItem;
import com.ywxiang.mall.model.OmsCartItemExample;
import com.ywxiang.mall.model.UmsMember;
import com.ywxiang.mall.portal.dao.PortalProductDao;
import com.ywxiang.mall.portal.domain.CartProduct;
import com.ywxiang.mall.portal.domain.CartPromotionItem;
import com.ywxiang.mall.portal.service.OmsCartItemService;
import com.ywxiang.mall.portal.service.OmsPromotionService;
import com.ywxiang.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
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
    @Autowired
    private OmsPromotionService promotionService;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public int add(OmsCartItem cartItem) {
        int count = 0;
        UmsMember currentMember = memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OmsCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null) {
            cartItem.setCreateDate(new Date());
            count = cartItemMapper.insert(cartItem);
        } else {
            cartItem.setModifyDate(new Date());
            existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
            count = cartItemMapper.updateByPrimaryKey(existCartItem);
        }
        return count;
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

    /**
     * 根据会员id,商品id和规格获取购物车中商品
     * @param cartItem
     * @return
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {
        OmsCartItemExample example = new OmsCartItemExample();
        OmsCartItemExample.Criteria criteria = example.createCriteria().andMemberIdEqualTo(cartItem.getMemberId())
                .andProductIdEqualTo(cartItem.getProductId()).andDeleteStatusEqualTo(0);
        if (!StringUtils.isEmpty(cartItem.getProductSkuId())) {
            criteria.andProductSkuIdEqualTo(cartItem.getProductSkuId());
        }
        List<OmsCartItem> cartItemList = cartItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(cartItemList)) {
            return cartItemList.get(0);
        }
        return null;
    }
}
