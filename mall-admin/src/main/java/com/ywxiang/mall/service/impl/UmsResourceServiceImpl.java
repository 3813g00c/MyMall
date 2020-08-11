package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.mapper.UmsResourceMapper;
import com.ywxiang.mall.model.UmsResource;
import com.ywxiang.mall.model.UmsResourceExample;
import com.ywxiang.mall.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:08
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private UmsResourceMapper resourceMapper;

    @Override
    public List<UmsResource> listAll() {
        return resourceMapper.selectByExample(new UmsResourceExample());
    }
}
