package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 定义商品审核日志管理Dao
 *
 * @author ywxiang
 * @date 2020/9/13 下午2:16
 */
public interface PmsProductVertifyRecordDao {

    /**
     * 批量创建
     *
     * @param list
     * @return
     */
    int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
