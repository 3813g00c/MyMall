package com.ywxiang.mall.service;

import com.ywxiang.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级管理Service2
 *
 * @author ywxiang
 * @date 2020/9/4 下午8:46
 */
public interface UmsMemberLevelService {

    /**
     * 获取所有会员等级
     *
     * @param defaultStatus
     * @return
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}
