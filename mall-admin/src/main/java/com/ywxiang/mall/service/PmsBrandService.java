package com.ywxiang.mall.service;

import com.ywxiang.mall.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌Service
 *
 * @author ywxiang
 * @date 2020/8/30 下午2:36
 */
public interface PmsBrandService {
    /**
     * 分页查询品牌
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize);
}
