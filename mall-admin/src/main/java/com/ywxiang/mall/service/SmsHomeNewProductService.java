package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsHomeNewProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页新品推荐Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:04
 */
public interface SmsHomeNewProductService {

    /**
     * 创建首页新品推荐
     *
     * @param homeNewProductList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(List<SmsHomeNewProduct> homeNewProductList);

    /**
     * 修改推荐排序
     *
     * @param id
     * @param sort
     * @return
     */
    int updateSort(Long id, Integer sort);

    /**
     * 批量删除推荐
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
     * 分页查询新品推荐
     *
     * @param productName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
