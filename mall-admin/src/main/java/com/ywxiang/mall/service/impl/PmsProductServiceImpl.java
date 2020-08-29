package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.PmsMemberPriceDao;
import com.ywxiang.mall.dto.PmsProductParam;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.mapper.PmsProductMapper;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductExample;
import com.ywxiang.mall.service.PmsProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 商品管理Service
 *
 * @author ywxiang
 * @date 2020/8/29 下午3:28
 */
@Service
@Slf4j
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
    PmsProductMapper productMapper;
    @Autowired
    PmsMemberPriceDao memberPriceDao;

    @Override
    public List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);

        if (productQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(productQueryParam.getPublishStatus());
        }
        if (productQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(productQueryParam.getProductSn());
        }
        if (productQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
        }
        if (productQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
        }

        return productMapper.selectByExample(productExample);
    }

    @Override
    public int create(PmsProductParam productParam) {
        return 0;
    }

    /**
     * 建立和插入关系操作
     * @param dao
     * @param dateList
     * @param productId
     */
    private void relationAndInsertList(Object dao, List dateList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dateList)) {
                return;
            }
            for (Object item : dateList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dateList);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.warn("创建产品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
