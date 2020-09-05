package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页品牌推荐Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:12
 */
public interface SmsHomeBrandService {

    /**
     * 添加首页推荐
     *
     * @param homeBrandList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * 更新推荐排序
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
     * 分页查询品牌推荐
     *
     * @param brandName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
