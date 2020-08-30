package com.ywxiang.mall.dao;

import com.ywxiang.mall.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/30 下午1:16
 */
public interface PmsProductLadderDao {

    /**
     * 批量创建
     * @param productLadderList
     * @return
     */
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
