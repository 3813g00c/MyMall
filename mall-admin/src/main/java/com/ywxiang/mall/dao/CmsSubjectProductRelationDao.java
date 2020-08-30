package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/30 下午1:22
 */
public interface CmsSubjectProductRelationDao {

    /**
     * 批量创建
     * @param subjectProductRelationList
     * @return
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
