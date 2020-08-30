package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 * @author ywxiang
 * @date 2020/8/30 下午1:21
 */
public interface PmsProductAttributeValueDao {

    /**
     * 批量创建
     * @param productAttributeValueList
     * @return
     */
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
