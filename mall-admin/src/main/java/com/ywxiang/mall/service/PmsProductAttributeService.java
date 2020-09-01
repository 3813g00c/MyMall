package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.PmsProductAttributeParam;
import com.ywxiang.mall.dto.ProductAttributeInfo;
import com.ywxiang.mall.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品属性Service
 *
 * @author ywxiang
 * @date 2020/9/1 下午9:59
 */
public interface PmsProductAttributeService {

    /**
     * 根据分类ID获取商品属性
     *
     * @param cId      分类Id
     * @param type     0->属性；2->参数
     * @param pageSize size
     * @param pageNum  num
     * @return PmsProductAttribute
     */
    List<PmsProductAttribute> getList(Long cId, Integer type, Integer pageSize, Integer pageNum);

    /**
     * 添加商品属性
     *
     * @param productAttributeParam
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(PmsProductAttributeParam productAttributeParam);

    /**
     * 更新商品属性
     *
     * @param id
     * @param productAttributeParam
     * @return
     */
    int update(Long id, PmsProductAttributeParam productAttributeParam);

    /**
     * 根据id获取商品属性
     *
     * @param id
     * @return
     */
    PmsProductAttribute getItem(Long id);

    /**
     * 批量删除商品属性
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int delete(List<Long> ids);

    /**
     * 根据商品分类Id获取对应的属性信息
     *
     * @param productCategoryId
     * @return
     */
    List<ProductAttributeInfo> getProductAttributeInfo(Long productCategoryId);
}
