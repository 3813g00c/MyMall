package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.SmsFlashPromotionProduct;
import com.ywxiang.mall.model.SmsFlashPromotionProductRelation;

import java.util.List;

/**
 * 限时购商品关联管理Service
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:24
 */
public interface SmsFlashPromotionProductRelationService {

    /**
     * 批量添加关联
     *
     * @param relationList
     * @return
     */
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * 修改关联相关信息
     *
     * @param id
     * @param relation
     * @return
     */
    int update(Long id, SmsFlashPromotionProductRelation relation);

    /**
     * 删除关联
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取关联详情
     *
     * @param id
     * @return
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * 分页查询相关商品以及促销信息
     *
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * 根据活动场次id获取商品关联数量
     *
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
}
