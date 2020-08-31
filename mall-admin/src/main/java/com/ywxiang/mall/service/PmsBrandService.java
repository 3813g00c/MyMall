package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsBrandParam;
import com.ywxiang.mall.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌Service
 *
 * @author ywxiang
 * @date 2020/8/30 下午2:36
 */
public interface PmsBrandService {

    /**
     * 获取所有商品品牌
     *
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 分页查询品牌
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize);

    /**
     * 创建品牌
     *
     * @param brandParam
     * @return
     */
    int createBrand(PmsBrandParam brandParam);

    /**
     * 修改品牌
     *
     * @param id
     * @param brandParam
     * @return
     */
    int updateBrand(Long id, PmsBrandParam brandParam);

    /**
     * 删除品牌
     *
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 批量删除品牌
     *
     * @param ids
     * @return
     */
    int deleteBrand(List<Long> ids);

    /**
     * 获取品牌
     *
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);

    /**
     * 修改显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 修改厂家制造商状态
     *
     * @param ids
     * @param factoryStatus
     * @return
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
