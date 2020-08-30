package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.mapper.PmsBrandMapper;
import com.ywxiang.mall.model.PmsBrand;
import com.ywxiang.mall.model.PmsBrandExample;
import com.ywxiang.mall.service.PmsBrandService;
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
}
