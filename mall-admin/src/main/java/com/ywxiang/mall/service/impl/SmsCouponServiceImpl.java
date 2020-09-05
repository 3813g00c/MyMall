package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dao.SmsCouponDao;
import com.ywxiang.mall.dao.SmsCouponProductCategoryRelationDao;
import com.ywxiang.mall.dao.SmsCouponProductRelationDao;
import com.ywxiang.mall.dto.SmsCouponParam;
import com.ywxiang.mall.mapper.SmsCouponMapper;
import com.ywxiang.mall.mapper.SmsCouponProductCategoryRelationMapper;
import com.ywxiang.mall.mapper.SmsCouponProductRelationMapper;
import com.ywxiang.mall.model.SmsCoupon;
import com.ywxiang.mall.model.SmsCouponProductCategoryRelation;
import com.ywxiang.mall.model.SmsCouponProductRelation;
import com.ywxiang.mall.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return 0;
    }

    @Override
    public int update(Long id, SmsCouponParam couponParam) {
        return 0;
    }

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public SmsCouponParam getItem(Long id) {
        return null;
    }
}
