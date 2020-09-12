package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.SmsFlashPromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义限时购商品关系管理Dao
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:38
 */
public interface SmsFlashPromotionProductRelationDao {
    /**
     * 获取限时购及相关商品信息
     *
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    List<SmsFlashPromotionProduct> getList(@Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
