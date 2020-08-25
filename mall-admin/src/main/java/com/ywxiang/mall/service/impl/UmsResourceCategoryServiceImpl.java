package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.mapper.UmsResourceCategoryMapper;
import com.ywxiang.mall.model.UmsResourceCategory;
import com.ywxiang.mall.model.UmsResourceCategoryExample;
import com.ywxiang.mall.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/25 下午10:05
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {

    @Autowired
    UmsResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }
}
