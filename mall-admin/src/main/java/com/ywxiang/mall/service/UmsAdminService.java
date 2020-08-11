package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsRole;

import java.util.List;

/**
 * 后台管理员Service
 *
 * @author ywxiang
 * @date 2020/8/11 下午9:02
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */

    UmsAdmin getAdminByUsername(String username);
    /**
     * 获取用户的角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);
}
