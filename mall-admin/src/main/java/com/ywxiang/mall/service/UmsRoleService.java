package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsMenu;
import com.ywxiang.mall.model.UmsRole;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:58
 */
public interface UmsRoleService {
    /**
     * 根据Id获取菜单
     * @param adminId
     * @return
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取所有角色列表
     * @return
     */
    List<UmsRole> list();
}
