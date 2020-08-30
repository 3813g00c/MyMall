package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品SKU管理Dao
 * @author ywxiang
 * @date 2020/8/30 下午1:20
 */
public interface PmsSkuStockDao {

    /**
     * 批量插入
     * @param skuStockList
     * @return
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);
}
