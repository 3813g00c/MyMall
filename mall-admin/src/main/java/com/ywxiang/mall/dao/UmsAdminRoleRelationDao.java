package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.UmsResource;
import com.ywxiang.mall.model.UmsRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色管理
 * @author ywxiang
 * @date 2020/8/8 下午11:25
 */
@Repository
public interface UmsAdminRoleRelationDao {
    /**
     * 获取指定用户的可访问资源
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 获取用户的角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);
}
