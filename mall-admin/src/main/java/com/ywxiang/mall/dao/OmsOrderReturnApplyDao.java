package com.ywxiang.mall.dao;

import com.ywxiang.mall.dto.OmsOrderReturnApplyResult;
import com.ywxiang.mall.dto.OmsReturnApplyQueryParam;
import com.ywxiang.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义退货申请Dao
 *
 * @author ywxiang
 * @date 2020/9/12 下午2:13
 */
@Repository
public interface OmsOrderReturnApplyDao {

    /**
     * 查询申请列表
     *
     * @param queryParam
     * @return
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam")OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     * @param id
     * @return
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
