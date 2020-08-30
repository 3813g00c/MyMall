package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品满减Dao
 *
 * @author ywxiang
 * @date 2020/8/30 下午1:18
 */
public interface PmsProductFullReductionDao {

    /**
     * 批量创建
     * @param productFullReductionList
     * @return
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
