package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsProductCategoryParam;
import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;
import com.ywxiang.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品分类Service
 * @author ywxiang
 * @date 2020/8/30 下午2:59
 */
public interface PmsProductCategoryService {
    /**
     * 以层级显示商品分类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    /**
     * 创建商品分类
     * @param productCategoryParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(PmsProductCategoryParam productCategoryParam);

    /**
     * 修改商品分类
     * @param id
     * @param productCategoryParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int update(Long id, PmsProductCategoryParam productCategoryParam);

    /**
     * 分页获取商品分类列表
     * @param parentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 根据Id删除商品分类
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取分类
     *
     * @param id
     * @return
     */
    PmsProductCategory getItem(Long id);

    /**
     * 批量修改导航状态
     *
     * @param ids
     * @param navStatus
     * @return
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);
}
