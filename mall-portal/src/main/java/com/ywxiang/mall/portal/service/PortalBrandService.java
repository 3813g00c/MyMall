package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.model.PmsBrand;
import com.ywxiang.mall.model.PmsProduct;

import java.util.List;

/**
 * 首页推荐品牌管理Service
 *
 * @author ywxiang
 * @date 2020/12/5 下午7:26
 */
public interface PortalBrandService {

    /**
     * 分页获取推荐品牌
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     *
     * @param brandId
     * @return
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关键商品
     *
     * @param brandId
     * @param pageNum
     * @param pageSize
     * @return
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
