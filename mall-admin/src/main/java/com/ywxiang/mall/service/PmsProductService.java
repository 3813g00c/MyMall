package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsProductParam;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理
 * @author ywxiang
 * @date 2020/8/29 下午3:25
 */
public interface PmsProductService {
    /**
     * 分页查询商品
     *
     * @param productQueryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 添加商品
     *
     * @param productParam
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int create(PmsProductParam productParam);
}
