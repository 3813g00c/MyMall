package com.ywxiang.mall.service;

import com.ywxiang.mall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * 首页广告管理Service
 *
 * @author ywxiang
 * @date 2020/9/7 下午8:39
 */
public interface SmsHomeAdvertiseService {

    /**
     * 添加广告
     *
     * @param advertise
     * @return
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * 删除广告
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 更新状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     *
     * @param id
     * @return
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * 更新广告信息
     *
     * @param id
     * @param advertise
     * @return
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * 分页查询广告列表
     *
     * @param name
     * @param type
     * @param endTime
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
