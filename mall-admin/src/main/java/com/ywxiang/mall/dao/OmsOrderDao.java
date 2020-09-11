package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.OmsOrderDeliveryParam;
import com.ywxiang.mall.dto.OmsOrderDetail;
import com.ywxiang.mall.dto.OmsOrderQueryParam;
import com.ywxiang.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单管理自定义Dao
 *
 * @author ywxiang
 * @date 2020/9/11 下午8:38
 */
@Repository
public interface OmsOrderDao {

    /**
     * 条件查询订单
     *
     * @param queryParam
     * @return
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     *
     * @param deliveryParams
     * @return
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParams);

    /**
     * 获取订单详情
     *
     * @param id
     * @return
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
