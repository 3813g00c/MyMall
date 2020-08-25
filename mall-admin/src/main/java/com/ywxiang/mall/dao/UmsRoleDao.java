package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.UmsMenu;
import com.ywxiang.mall.model.UmsResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义后台角色管理Dao
 *
 * @author ywxiang
 * @date 2020/8/11 下午10:00
 */
@Repository
public interface UmsRoleDao {
    /**
     * 根据Id获取菜单
     *
     * @param adminId
     * @return
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);

    /**
     * 根据角色获得菜单
     * @param roleId
     * @return
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色id获得菜单
     * @param roleId
     * @return
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
