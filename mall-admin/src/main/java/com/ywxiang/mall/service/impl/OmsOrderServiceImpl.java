package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dto.*;
import com.ywxiang.mall.model.OmsOrder;
import com.ywxiang.mall.service.OmsOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/10 下午8:25
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        return 0;
    }

    @Override
    public int close(List<Long> ids, String note) {
        return 0;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return null;
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        return 0;
    }

    @Override
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        return 0;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        return 0;
    }
}
