package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 自定义优惠券Dao
 *
 * @author ywxiang
 * @date 2020/9/5 下午5:01
 */
@Repository
public interface SmsCouponDao {
    /**
     * 获取优惠券详情包含绑定关系
     *
     * @param id
     * @return
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
