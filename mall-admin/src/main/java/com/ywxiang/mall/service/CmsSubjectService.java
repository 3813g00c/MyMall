package com.ywxiang.mall.service;

import com.ywxiang.mall.model.CmsSubject;

import java.util.List;

/**
 * 商品专题Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午1:12
 */
public interface CmsSubjectService {

    /**
     * 查询所有商品专题
     *
     * @return
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询商品专题
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

}
