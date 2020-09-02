package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.PmsProductAttributeDao;
import com.ywxiang.mall.dto.PmsProductAttributeParam;
import com.ywxiang.mall.dto.ProductAttributeInfo;
import com.ywxiang.mall.mapper.PmsProductAttributeCategoryMapper;
import com.ywxiang.mall.mapper.PmsProductAttributeMapper;
import com.ywxiang.mall.model.PmsProductAttribute;
import com.ywxiang.mall.model.PmsProductAttributeCategory;
import com.ywxiang.mall.model.PmsProductAttributeExample;
import com.ywxiang.mall.service.PmsProductAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    PmsProductAttributeDao productAttributeDao;

    @Override
    public List<PmsProductAttribute> getList(Long cId, Integer type, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cId).andTypeEqualTo(type);
        return productAttributeMapper.selectByExample(example);
    }

    @Override
    public int create(PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute productAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(productAttributeParam, productAttribute);
        int count = productAttributeMapper.insertSelective(productAttribute);

        // 新增商品属性以后要更新商品属性分类数量
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper
                .selectByPrimaryKey(productAttribute.getProductAttributeCategoryId());
        if (productAttribute.getType() == 0) {
            productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount() + 1);
        } else if (productAttribute.getType() == 1) {
            productAttributeCategory.setParamCount(productAttributeCategory.getParamCount() + 1);
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
    }

    @Override
    public int update(Long id, PmsProductAttributeParam productAttributeParam) {
        PmsProductAttribute productAttribute = new PmsProductAttribute();
        productAttribute.setId(id);
        BeanUtils.copyProperties(productAttributeParam, productAttribute);
        return productAttributeMapper.updateByPrimaryKeySelective(productAttribute);
    }

    @Override
    public PmsProductAttribute getItem(Long id) {
        return productAttributeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(List<Long> ids) {
        // 获取分类
        PmsProductAttribute productAttribute = productAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = productAttribute.getType();
        PmsProductAttributeCategory productAttributeCategory = productAttributeCategoryMapper
                .selectByPrimaryKey(productAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = productAttributeMapper.deleteByExample(example);
        // 删除完成后修改数量
        if (type == 0) {
            if (productAttributeCategory.getAttributeCount() >= count) {
                productAttributeCategory.setAttributeCount(productAttributeCategory.getAttributeCount() - count);
            } else {
                productAttributeCategory.setAttributeCount(0);
            }
        } else if (type == 1) {
            if (productAttributeCategory.getParamCount() >= count) {
                productAttributeCategory.setParamCount(productAttributeCategory.getParamCount() - count);
            } else {
                productAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(productAttributeCategory);
        return count;
    }

    @Override
    public List<ProductAttributeInfo> getProductAttributeInfo(Long productCategoryId) {
        return productAttributeDao.getProductAttrInfo(productCategoryId);
    }
}
