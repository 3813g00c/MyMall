package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.mapper.SmsHomeRecommendSubjectMapper;
import com.ywxiang.mall.model.SmsHomeRecommendSubject;
import com.ywxiang.mall.model.SmsHomeRecommendSubjectExample;
import com.ywxiang.mall.service.SmsHomeRecommendSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/5 下午3:24
 */
@Service
public class SmsHomeRecommendSubjectServiceImpl implements SmsHomeRecommendSubjectService {

    @Autowired
    SmsHomeRecommendSubjectMapper homeRecommendSubjectMapper;

    @Override
    public int create(List<SmsHomeRecommendSubject> recommendSubjectList) {
        for (SmsHomeRecommendSubject homeRecommendSubject : recommendSubjectList) {
            homeRecommendSubject.setRecommendStatus(1);
            homeRecommendSubject.setSort(0);
            homeRecommendSubjectMapper.insert(homeRecommendSubject);
        }
        return recommendSubjectList.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendSubject recommendProduct = new SmsHomeRecommendSubject();
        recommendProduct.setId(id);
        recommendProduct.setSort(sort);
        return homeRecommendSubjectMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        return homeRecommendSubjectMapper.deleteByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeRecommendSubject record = new SmsHomeRecommendSubject();
        record.setRecommendStatus(recommendStatus);
        return homeRecommendSubjectMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsHomeRecommendSubjectExample example = new SmsHomeRecommendSubjectExample();
        SmsHomeRecommendSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(subjectName)) {
            criteria.andSubjectNameLike("%" + subjectName + "%");
        }
        if (recommendStatus != null) {
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeRecommendSubjectMapper.selectByExample(example);
    }
}
