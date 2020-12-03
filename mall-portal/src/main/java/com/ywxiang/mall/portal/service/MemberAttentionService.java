package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;

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

    /**
     * 取消关注
     *
     * @param brandId
     * @return
     */
    int delete(Long brandId);

    /**
     * 获取用户关注列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);

    /**
     * 获取用户关注详情
     *
     * @param brandId
     * @return
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * 清空关注列表
     */
    void clear();
}
