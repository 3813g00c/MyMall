package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页人气推荐Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午3:49
 */
public interface SmsHomeRecommendProductService {
    /**
     * 添加首页人气推荐
     *
     * @param homeRecommendProductList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    /**
     * 修改推荐状态
     *
     * @param id
     * @param sort
     * @return
     */
    int updateSort(Long id, Integer sort);

    /**
     * 批量删除人气推荐
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 更新推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询人气推荐
     *
     * @param productName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
