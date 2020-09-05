package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsHomeRecommendSubject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 首页专题推荐Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午3:19
 */
public interface SmsHomeRecommendSubjectService {

    /**
     * 添加首页推荐
     *
     * @param recommendSubjectList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int create(List<SmsHomeRecommendSubject> recommendSubjectList);

    /**
     * 修改推荐排序
     *
     * @param id
     * @param sort
     * @return
     */
    int updateSort(Long id, Integer sort);

    /**
     * 批量删除推荐
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 更新推荐状态
     *
     * @param ids
     * @param recommendStatus
     * @return
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 分页查询推荐
     *
     * @param subjectName
     * @param recommendStatus
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
