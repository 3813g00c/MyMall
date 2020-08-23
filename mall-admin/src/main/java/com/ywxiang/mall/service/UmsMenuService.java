package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.UmsMenuNode;

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
}
