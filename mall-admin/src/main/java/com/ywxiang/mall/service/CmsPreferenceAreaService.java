package com.ywxiang.mall.service;

import com.ywxiang.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * 优选专区Service
 *
 * @author ywxiang
 * @date 2020/9/5 下午1:42
 */
public interface CmsPreferenceAreaService {
    /**
     * 获取所有优选分区
     * @return
     */
    List<CmsPrefrenceArea> listAll();
}
