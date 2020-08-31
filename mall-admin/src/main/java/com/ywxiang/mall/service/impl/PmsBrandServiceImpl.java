package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dto.PmsBrandParam;
import com.ywxiang.mall.mapper.PmsBrandMapper;
import com.ywxiang.mall.mapper.PmsProductMapper;
import com.ywxiang.mall.model.PmsBrand;
import com.ywxiang.mall.model.PmsBrandExample;
import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.PmsProductExample;
import com.ywxiang.mall.service.PmsBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/30 下午2:37
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    PmsBrandMapper brandMapper;
    @Autowired
    PmsProductMapper productMapper;

    @Override
    public List<PmsBrand> listBrand(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample example = new PmsBrandExample();
        example.setOrderByClause("sort desc");
        PmsBrandExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrandParam brandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(brandParam, pmsBrand);
        // 如果创建时首字母为空， 取名称的第一个为首字符
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        return brandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam brandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(brandParam, pmsBrand);
        pmsBrand.setId(id);
        // 如果创建时首字母为空， 取名称的第一个为首字母
        if (StringUtils.isEmpty(pmsBrand.getFirstLetter())) {
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1));
        }
        // 更新品牌名时要更新商品中的品牌名称
        PmsProduct product = new PmsProduct();
        product.setBrandName(pmsBrand.getName());
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andBrandIdEqualTo(id);
        productMapper.updateByExampleSelective(product, example);
        return brandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.deleteByExample(example);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        PmsBrandExample example = new PmsBrandExample();
        example.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(pmsBrand, example);
    }

    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return brandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }
}
