package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/30 下午1:24
 */
public interface CmsPreferenceAreaProductRelationDao {
    /**
     * 批量创建
     * @param prefrenceAreaProductRelationList
     * @return
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
