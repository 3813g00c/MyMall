package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dao.PmsProductCategoryDao;
import com.ywxiang.mall.dto.PmsProductCategoryWithChildrenItem;
import com.ywxiang.mall.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryDao.listWithChildren();
    }
}
