package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsProductParam;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.dto.PmsProductResult;
import com.ywxiang.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理
 *
 * @author ywxiang
 * @date 2020/8/29 下午3:25
 */
public interface PmsProductService {
    /**
     * 分页查询商品
     *
     * @param productQueryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 添加商品
     *
     * @param productParam
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    int create(PmsProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     *
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     *
     * @param id
     * @param productParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int update(Long id, PmsProductParam productParam);

    /**
     * 批量修改审核状态
     *
     * @param ids
     * @param verifyStatus
     * @param detail
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 修改商品上架时的显示状态
     *
     * @param ids
     * @param publishStatus
     * @return
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品的推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改商品的新品状态
     *
     * @param ids
     * @param newStatus
     * @return
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     *
     * @param ids
     * @param deleteStatus
     * @return
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     *
     * @param keyword
     * @return
     */
    List<PmsProduct> list(String keyword);
}
