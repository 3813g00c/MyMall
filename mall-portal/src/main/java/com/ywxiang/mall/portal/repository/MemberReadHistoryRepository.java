package com.ywxiang.mall.portal.repository;

import com.ywxiang.mall.portal.domain.MemberReadHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员商品浏览历史Repository
 *
 * @author ywxiang
 * @date 2020/12/4 下午7:44
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    /**
     * 查询浏览记录
     *
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);

    /**
     * 删除所有浏览记录
     *
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);
}