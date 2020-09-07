package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * 秒杀活动管理Service
 *
 * @author ywxiang
 * @date 2020/9/6 下午5:13
 */
public interface SmsFlashPromotionService {

    /**
     * 添加活动
     *
     * @param flashPromotion
     * @return
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * 修改活动
     *
     * @param id
     * @param flashPromotion
     * @return
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * 删除活动
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改活动状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id, Integer status);

    /**
     * 分页查询活动列表
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 获取单个秒杀活动
     *
     * @param id
     * @return
     */
    SmsFlashPromotion getItem(Long id);
}
