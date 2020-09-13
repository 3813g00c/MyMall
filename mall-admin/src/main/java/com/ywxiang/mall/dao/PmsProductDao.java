package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 自定义商品管理Dao
 *
 * @author ywxiang
 * @date 2020/9/13 下午1:24
 */
@Repository
public interface PmsProductDao {

    /**
     * 获取商品编辑信息
     *
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
