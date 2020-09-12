package com.ywxiang.mall.service;

import com.ywxiang.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * 订单原因管理Service
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:06
 */
public interface OmsOrderReturnReasonService {

    /**
     * 添加退回原因
     *
     * @param returnReason
     * @return
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 修改退货原因
     *
     * @param id
     * @param returnReason
     * @return
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 分页查询退货原因
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * 批量修改退货原因状态
     *
     * @param ids
     * @param status
     * @return
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     *
     * 获取单个退货原因详情
     * @param id
     * @return
     */
    OmsOrderReturnReason getItem(Long id);
}
