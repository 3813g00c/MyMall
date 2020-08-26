package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsResource;

import java.util.List;

/**
 * 后台资源管理Service
 *
 * @author ywxiang
 * @date 2020/8/11 下午9:06
 */
public interface UmsResourceService {
    /**
     * 查询所有资源
     *
     * @return
     */
    List<UmsResource> listAll();

    /**
     * 分页查询后台资源
     * @param categoryId
     * @param nameKeyword
     * @param urlKeyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 删除资源
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取资源详情
     * @param id
     * @return
     */
    UmsResource getItem(Long id);

    /**
     * 修改资源
     * @param id
     * @param umsResource
     * @return
     */
    int update(Long id, UmsResource umsResource);

    /**
     * 添加资源
     * @param umsResource
     * @return
     */
    int create(UmsResource umsResource);
}
