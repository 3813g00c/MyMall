package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.*;
import com.ywxiang.mall.dto.PmsProductParam;
import com.ywxiang.mall.dto.PmsProductQueryParam;
import com.ywxiang.mall.mapper.PmsProductMapper;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductExample;
import com.ywxiang.mall.model.PmsSkuStock;
import com.ywxiang.mall.service.PmsProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    PmsProductLadderDao productLadderDao;
    @Autowired
    PmsProductFullReductionDao productFullReductionDao;
    @Autowired
    PmsSkuStockDao skuStockDao;
    @Autowired
    PmsProductAttributeValueDao productAttributeValueDao;
    @Autowired
    CmsSubjectProductRelationDao subjectProductRelationDao;
    @Autowired
    CmsPreferenceAreaProductRelationDao preferenceAreaProductRelationDao;

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
        int count;
        // 创建商品
        PmsProduct product = productParam;
        product.setId(null);
        productMapper.insertSelective(product);
        // 根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        // 会员价格
        relationAndInsertList(memberPriceDao, productParam.getMemberPriceList(), productId);
        // 阶梯价格
        relationAndInsertList(productLadderDao, productParam.getProductLadderList(), productId);
        // 满减价格
        relationAndInsertList(productFullReductionDao, productParam.getProductFullReductionList(), productId);
        // 处理SKu编码
        handleSkuStockCode(productParam.getSkuStockList(), productId);
        // 添加Sku库存信息
        relationAndInsertList(skuStockDao, productParam.getSkuStockList(), productId);
        // 添加商品参数，添加自定义商品规格
        relationAndInsertList(productAttributeValueDao, productParam.getProductAttributeValueList(), productId);
        // 关联专题
        relationAndInsertList(subjectProductRelationDao, productParam.getSubjectProductRelationList(), productId);
        // 关联优选
        relationAndInsertList(preferenceAreaProductRelationDao, productParam.getPrefrenceAreaProductRelationList(), productId);
        count = 1;
        return count;
    }

    /**
     * 建立和插入关系操作
     *
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
                setId.invoke(item, (Long) null);
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

    /**
     * 处理Sku编码
     * @param skuStockList
     * @param productId
     */
    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList)) {
            return;
        }
        for (int i = 0; i < skuStockList.size(); i++) {
            PmsSkuStock skuStock = skuStockList.get(i);
            if (StringUtils.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                // 日期
                sb.append(dateFormat.format(new Date()));
                // 思维商品id
                sb.append(String.format("%04d", productId));
                // 三位索引Id
                sb.append(String.format("%03d", i + 1));
                skuStock.setSkuCode(sb.toString());
            }
        }
    }
}
