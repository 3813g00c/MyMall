package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.UmsMenuNode;
import com.ywxiang.mall.model.UmsMenu;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/23 下午8:10
 */
public interface UmsMenuService {
    /**
     * 树形结构返回所有菜单列表
     * @return UmsMenuNode
     */
    List<UmsMenuNode> treeList();

    /**
     * 分页查询后台菜单
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 添加后台菜单
     * @param umsMenu
     * @return
     */
    int create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     * @param id
     * @param umsMenu
     * @return
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 根据ID获得菜单详情
     * @param id
     * @return
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改菜单显示状态
     * @param id
     * @param hidden
     * @return
     */
    int updateHidden(Long id, Integer hidden);
}
