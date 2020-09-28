package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.portal.domain.MemberBrandAttention;

/**
 * 会员品牌关注管理Service
 *
 * @author ywxiang
 * @date 2020/9/28 下午10:10
 */
public interface MemberAttentionService {

    /**
     * 添加关注
     *
     * @param memberBrandAttention
     * @return
     */
    int add(MemberBrandAttention memberBrandAttention);
}
