package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.mapper.SmsHomeAdvertiseMapper;
import com.ywxiang.mall.model.SmsHomeAdvertise;
import com.ywxiang.mall.model.SmsHomeAdvertiseExample;
import com.ywxiang.mall.portal.domain.HomeContentResult;
import com.ywxiang.mall.portal.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/16 下午9:58
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    SmsHomeAdvertiseMapper advertiseMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        result.setAdvertiseList(getHomeAdvertiseList());
        return null;
    }

    /**
     * 获取轮播广告列表
     *
     * @return
     */
    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }
}
