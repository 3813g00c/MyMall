package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.*;
import com.ywxiang.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 *
 * @author ywxiang
 * @date 2020/9/9 下午8:37
 */
public interface OmsOrderService {

    /**
     * 订单查询
     *
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 订单发货
     *
     * @param deliveryParamList
     * @return
     */
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 订单关闭
     *
     * @param ids
     * @param note
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int close(List<Long> ids, String note);

    /**
     * 删除订单
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 订单详情
     *
     * @param id
     * @return
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     *
     * @param receiverInfoParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用
     *
     * @param moneyInfoParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     *
     * @param id
     * @param note
     * @param status
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateNote(Long id, String note, Integer status);
}
