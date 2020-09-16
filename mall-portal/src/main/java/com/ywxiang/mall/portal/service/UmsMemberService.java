package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 会员管理Service
 *
 * @author ywxiang
 * @date 2020/9/16 下午9:26
 */
public interface UmsMemberService {

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取会员信息
     *
     * @param username
     * @return
     */
    UmsMember getByUsername(String username);
}
