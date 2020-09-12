package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义操作记录DAO
 *
 * @author ywxiang
 * @date 2020/9/12 下午1:25
 */
@Repository
public interface OmsOrderOperateHistoryDao {

    /**
     * 批量创建操作记录
     *
     * @param orderOperateHistories
     * @return
     */
    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistories);
}
