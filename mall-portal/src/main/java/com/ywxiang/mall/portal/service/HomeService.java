package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.model.CmsSubject;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductCategory;
import com.ywxiang.mall.portal.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理Service
 *
 * @author ywxiang
 * @date 2020/9/16 下午9:52
 */
public interface HomeService {

    /**
     * 获取首页内容
     *
     * @return
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     *
     * @param parentId
     * @return
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     *
     * @param cateId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**
     * 分页获取人气推荐商品
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}
