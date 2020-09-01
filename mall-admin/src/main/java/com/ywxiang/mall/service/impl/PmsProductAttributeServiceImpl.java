package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dto.PmsProductAttributeParam;
import com.ywxiang.mall.dto.ProductAttributeInfo;
import com.ywxiang.mall.model.PmsProductAttribute;
import com.ywxiang.mall.service.PmsProductAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类属性Service
 *
 * @author ywxiang
 * @date 2020/9/1 下午10:10
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {
    @Override
    public List<PmsProductAttribute> getList(Long cId, Integer type, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int create(PmsProductAttributeParam productAttributeParam) {
        return 0;
    }

    @Override
    public int update(Long id, PmsProductAttributeParam productAttributeParam) {
        return 0;
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        return null;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public List<ProductAttributeInfo> getProductAttributeInfo(Long productCategoryId) {
        return null;
    }
}
