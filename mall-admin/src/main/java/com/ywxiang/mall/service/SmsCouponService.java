package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.SmsCouponParam;
import com.ywxiang.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 优惠券管理Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:46
 */
public interface SmsCouponService {

    /**
     * 创建优惠卷
     *
     * @param smsCouponParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(SmsCouponParam smsCouponParam);

    /**
     * 根据ID删除优惠券
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int delete(Long id);

    /**
     * 更新优惠券信息
     *
     * @param id
     * @param couponParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int update(Long id, SmsCouponParam couponParam);

    /**
     * 分页获取优惠券
     *
     * @param name
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 获取优惠券详情
     *
     * @param id
     * @return
     */
    SmsCouponParam getItem(Long id);
}
