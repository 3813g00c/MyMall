package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.mapper.CmsPrefrenceAreaMapper;
import com.ywxiang.mall.model.CmsPrefrenceArea;
import com.ywxiang.mall.model.CmsPrefrenceAreaExample;
import com.ywxiang.mall.service.CmsPreferenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/5 下午1:44
 */
@Service
public class CmsPreferenceAreaServiceImpl implements CmsPreferenceAreaService {

    @Autowired
    CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
