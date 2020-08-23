package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.UmsAdminParam;
import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 根据用户名查询用户
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 修改用户信息
     * @param id
     * @param admin
     * @return
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 修改用户角色关系
     *
     * @param adminId
     * @param roleIds
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 添加后台用户
     *
     * @param adminParam
     * @return
     */
    UmsAdmin addAdmin(UmsAdminParam adminParam);
}
