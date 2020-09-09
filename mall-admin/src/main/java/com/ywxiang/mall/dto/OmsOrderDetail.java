package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.OmsOrder;
import com.ywxiang.mall.model.OmsOrderItem;
import com.ywxiang.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/9 下午8:42
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;

    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
