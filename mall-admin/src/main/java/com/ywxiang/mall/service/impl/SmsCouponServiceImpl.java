package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.SmsCouponDao;
import com.ywxiang.mall.dao.SmsCouponProductCategoryRelationDao;
import com.ywxiang.mall.dao.SmsCouponProductRelationDao;
import com.ywxiang.mall.dto.SmsCouponParam;
import com.ywxiang.mall.mapper.SmsCouponMapper;
import com.ywxiang.mall.mapper.SmsCouponProductCategoryRelationMapper;
import com.ywxiang.mall.mapper.SmsCouponProductRelationMapper;
import com.ywxiang.mall.model.*;
import com.ywxiang.mall.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/5 下午4:50
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {

    @Autowired
    SmsCouponMapper couponMapper;
    @Autowired
    SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    SmsCouponProductRelationDao couponProductRelationDao;
    @Autowired
    SmsCouponProductCategoryRelationDao couponProductCategoryRelationDao;
    @Autowired
    SmsCouponDao couponDao;

    @Override
    public int create(SmsCouponParam smsCouponParam) {
        // 设置发行数量
        smsCouponParam.setCount(smsCouponParam.getPublishCount());
        // 设置使用数量
        smsCouponParam.setUseCount(0);
        // 设置领取数量
        smsCouponParam.setReceiveCount(0);
        int count = couponMapper.insert(smsCouponParam);
        // 插入优惠券与商品关系表
        if (smsCouponParam.getUseType().equals(2)) {
            for (SmsCouponProductRelation productRelation : smsCouponParam.getProductRelationList()) {
                productRelation.setCouponId(smsCouponParam.getId());
            }
            couponProductRelationDao.insertList(smsCouponParam.getProductRelationList());
        }
        // 插入优惠券与商品分类关系表
        if (smsCouponParam.getUseType().equals(1)) {
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : smsCouponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(smsCouponParam.getId());
            }
            couponProductCategoryRelationDao.insertList(smsCouponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        // 删除优惠券
        int count = couponMapper.deleteByPrimaryKey(id);
        // 删除商品关联
        deleteProductRelation(id);
        // 删除商品分类关联
        deleteProductCategoryRelation(id);
        return count;
    }

    @Override
    public int update(Long id, SmsCouponParam couponParam) {
        couponParam.setId(id);
        int count = couponMapper.updateByPrimaryKey(couponParam);
        // 删除后插入优惠券和商品关系表
        if (couponParam.getUseType().equals(2)) {
            for (SmsCouponProductRelation productRelation : couponParam.getProductRelationList()) {
                productRelation.setCouponId(couponParam.getId());
            }
            deleteProductRelation(id);
            couponProductRelationDao.insertList(couponParam.getProductRelationList());
        }
        // 删除后插入优惠券和商品分类关系表
        if (couponParam.getUseType().equals(1)) {
            for (SmsCouponProductCategoryRelation couponProductCategoryRelation : couponParam.getProductCategoryRelationList()) {
                couponProductCategoryRelation.setCouponId(couponParam.getId());
            }
            deleteProductCategoryRelation(id);
            couponProductCategoryRelationDao.insertList(couponParam.getProductCategoryRelationList());
        }
        return count;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        PageHelper.startPage(pageNum, pageSize);
        return couponMapper.selectByExample(example);
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }

    /**
     * 删除商品与优惠券的关联关系
     *
     * @param id
     */
    private void deleteProductRelation(Long id) {
        SmsCouponProductRelationExample productRelationExample = new SmsCouponProductRelationExample();
        productRelationExample.createCriteria().andCouponIdEqualTo(id);
        couponProductRelationMapper.deleteByExample(productRelationExample);
    }

    /**
     * 删除商品分类与优惠券的关联关系
     *
     * @param id
     */
    private void deleteProductCategoryRelation(Long id) {
        SmsCouponProductCategoryRelationExample productCategoryRelationExample = new SmsCouponProductCategoryRelationExample();
        productCategoryRelationExample.createCriteria().andCouponIdEqualTo(id);
        couponProductCategoryRelationMapper.deleteByExample(productCategoryRelationExample);
    }

}
