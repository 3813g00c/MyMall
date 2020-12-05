package com.ywxiang.mall.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.api.CommonPage;
import com.ywxiang.mall.mapper.PmsBrandMapper;
import com.ywxiang.mall.mapper.PmsProductMapper;
import com.ywxiang.mall.model.PmsBrand;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductExample;
import com.ywxiang.mall.portal.dao.HomeDao;
import com.ywxiang.mall.portal.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/12/5 下午7:30
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeDao.getRecommendBrandList(offset, pageSize);
    }

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
