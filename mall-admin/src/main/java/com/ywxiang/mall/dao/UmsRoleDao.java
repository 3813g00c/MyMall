package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.UmsMenu;
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
     * @param adminId
     * @return
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
