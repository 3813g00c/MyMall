package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsMenu;
import com.ywxiang.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 分页查询所有角色
     * @return
     */
    List<UmsRole> listByPage(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 更新角色
     *
     * @param id
     * @param role
     * @return
     */
    int update(Long id, UmsRole role);

    /**
     * 获取角色相关菜单
     *
     * @param roleId
     * @return
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 给角色分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int allocMenu(Long roleId, List<Long> menuIds);
}
