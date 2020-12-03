package com.ywxiang.mall.portal.repository;

import com.ywxiang.mall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ywxiang
 * @date 2020/12/3 下午8:20
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention, String> {

    /**
     * 查询关注
     *
     * @param memberId
     * @param brandId
     * @return
     */
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);

    /**
     * 取消关注
     *
     * @param memberId
     * @param brandId
     * @return
     */
    int deleteByMemberIdAndBrandId(Long memberId, Long brandId);

    /**
     * 分页查询
     *
     * @param memberId
     * @param pageable
     * @return
     */
    Page<MemberBrandAttention> findByMemberId(Long memberId, Pageable pageable);

    /**
     * 清空所有关注信息
     * @param memberId
     */
    void deleteAllByMemberId(Long memberId);
}
