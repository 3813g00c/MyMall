package com.ywxiang.mall.portal.dao;

import com.ywxiang.mall.model.CmsSubject;
import com.ywxiang.mall.model.PmsBrand;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义首页信息Dao
 *
 * @author ywxiang
 * @date 2020/9/17 下午9:00
 */
@Repository
public interface HomeDao {

    /**
     * 获取秒杀商品
     *
     * @param flashPromotionId
     * @param sessionId
     * @return
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取推荐品牌
     *
     * @param offset
     * @param limit
     * @return
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取首页新品推荐
     *
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取首页人气推荐
     *
     * @param offset
     * @param limit
     * @return
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取首页推荐专题
     *
     * @param offset
     * @param limit
     * @return
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
