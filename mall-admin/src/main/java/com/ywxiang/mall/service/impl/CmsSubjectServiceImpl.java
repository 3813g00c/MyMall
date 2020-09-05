package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.mapper.CmsSubjectMapper;
import com.ywxiang.mall.model.CmsSubject;
import com.ywxiang.mall.model.CmsSubjectExample;
import com.ywxiang.mall.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/5 下午1:14
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {

    @Autowired
    CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }
}
