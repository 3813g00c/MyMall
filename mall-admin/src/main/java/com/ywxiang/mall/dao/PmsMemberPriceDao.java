package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义会员价格Dao
 *
 * @author ywxiang
 * @date 2020/8/29 下午5:03
 */
@Repository
public interface PmsMemberPriceDao {
    /**
     * 批量创建
     *
     * @param memberPriceList
     * @return
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
