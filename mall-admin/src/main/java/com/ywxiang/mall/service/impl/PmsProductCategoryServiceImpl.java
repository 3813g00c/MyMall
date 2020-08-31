package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dao.PmsProductCategoryDao;
import com.ywxiang.mall.dto.PmsProductCategoryParam;
import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;
import com.ywxiang.mall.mapper.PmsProductCategoryMapper;
import com.ywxiang.mall.model.PmsProductCategory;
import com.ywxiang.mall.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 商品分类管理Service
 *
 * @author ywxiang
 * @date 2020/8/30 下午3:02
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    PmsProductCategoryDao productCategoryDao;
    @Autowired
    PmsProductCategoryMapper productCategoryMapper;

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }

    @Override
    public int create(PmsProductCategoryParam productCategoryParam) {
        PmsProductCategory productCategory = new PmsProductCategory();
        productCategory.setProductCount(0);
        BeanUtils.copyProperties(productCategoryParam, productCategory);
        // 设置等级
        setCategoryLevel(productCategory);
        int count = productCategoryMapper.insertSelective(productCategory);
        // 创建筛选属性关联
        List<Long> productAttributeIdList = productCategoryParam.getProductAttributeIdList();
        if (!CollectionUtils.isEmpty(productAttributeIdList)) {

        }
        return 0;
    }

    @Override
    public int update(Long id, PmsProductCategoryParam productCategoryParam) {
        return 0;
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return null;
    }

    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        return 0;
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        return 0;
    }

    /**
     * 设置商品分类level
     * @param productCategory
     */
    private void setCategoryLevel(PmsProductCategory productCategory) {
        // 没有父分类时为一级分类
        if (productCategory.getParentId() == 0) {
            productCategory.setLevel(0);
        } else {
            // 有父类时根据父类设置等级
            PmsProductCategory parentCategory = productCategoryMapper.selectByPrimaryKey(productCategory.getParentId());
            if (parentCategory != null) {
                productCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                productCategory.setLevel(0);
            }
        }
    }
}
