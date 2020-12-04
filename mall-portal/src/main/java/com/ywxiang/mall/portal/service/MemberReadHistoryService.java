package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 会员浏览记录管理Service
 *
 * @author ywxiang
 * @date 2020/12/4 下午7:41
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     *
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     *
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 分页获取浏览记录
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * 清空浏览记录
     */
    void clear();
}
