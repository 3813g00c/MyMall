package com.ywxiang.mall.portal.service;

import com.ywxiang.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员收藏管理Service
 *
 * @author ywxiang
 * @date 2020/12/3 下午9:06
 */
public interface MemberCollectionService {

    /**
     * 添加收藏
     *
     * @param productCollection
     * @return
     */
    int add(MemberProductCollection productCollection);

    /**
     * 删除收藏
     *
     * @param productId
     * @return
     */
    int delete(long productId);

    /**
     * 分页查询收藏
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * 查看收藏详情
     *
     * @param productId
     * @return
     */
    MemberProductCollection detail(Long productId);

    /**
     * 清空收藏
     */
    void clear();
}
