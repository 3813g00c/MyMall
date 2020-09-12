package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.OmsOrderReturnApplyResult;
import com.ywxiang.mall.dto.OmsReturnApplyQueryParam;
import com.ywxiang.mall.dto.OmsUpdateStatusParam;
import com.ywxiang.mall.model.OmsOrderReturnApply;

import java.util.List;

/**
 * 退货申请管理Service
 *
 * @author ywxiang
 * @date 2020/9/12 下午2:03
 */
public interface OmsOrderReturnApplyService {

    /**
     * 分页查询退货申请
     *
     * @param queryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 删除退货申请
     *
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     *
     * @param id
     * @param statusParam
     * @return
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请状态
     *
     * @param id
     * @return
     */
    OmsOrderReturnApplyResult getItem(Long id);

}
