package com.ywxiang.mall.service;

import com.ywxiang.mall.model.OmsOrderSetting;

/**
 * 订单设置Service
 *
 * @author ywxiang
 * @date 2020/9/7 下午9:09
 */
public interface OmsOrderSettingService {

    /**
     * 获取指定订单设置
     *
     * @param id
     * @return
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     *
     * @param id
     * @param orderSetting
     * @return
     */
    int update(Long id, OmsOrderSetting orderSetting);
}
