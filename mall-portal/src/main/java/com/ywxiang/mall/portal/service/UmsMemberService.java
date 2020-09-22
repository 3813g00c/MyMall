package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 根据会员编号获取会员
     *
     * @param id
     * @return
     */
    UmsMember getById(Long id);

    /**
     * 会员注册
     *
     * @param username
     * @param password
     * @param telephone
     * @param authCode
     */
    @Transactional(rollbackFor = Exception.class)
    void register(String username, String password, String telephone, String authCode);

    /**
     * 修改密码
     *
     * @param telephone
     * @param password
     * @param authCode
     */
    @Transactional(rollbackFor = Exception.class)
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 生成验证码
     *
     * @param telephone
     * @return
     */
    String generateAuthCode(String telephone);

    /**
     * 获取当前登录会员
     *
     * @return
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     *
     * @param id
     * @param integration
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * 登录后获取token
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token
     *
     * @param token
     * @return
     */
    String refreshToken(String token);
}
