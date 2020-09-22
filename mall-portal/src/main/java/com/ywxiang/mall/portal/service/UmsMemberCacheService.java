package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.model.UmsMember;

/**
 * 会员信息缓存业务类
 *
 * @author ywxiang
 * @date 2020/9/22 下午8:55
 */
public interface UmsMemberCacheService {

    /**
     * 删除会员用户缓存
     *
     * @param memberId
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     *
     * @param username
     * @return
     */
    UmsMember getMember(String username);

    /**
     * 设置会员用户缓存
     *
     * @param member
     */
    void setMember(UmsMember member);

    /**
     * 设置验证码
     *
     * @param telephone
     * @param authCode
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     *
     * @param telephone
     * @return
     */
    String getAuthCode(String telephone);

}
