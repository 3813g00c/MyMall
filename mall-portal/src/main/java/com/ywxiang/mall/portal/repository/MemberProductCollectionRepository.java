package com.ywxiang.mall.portal.repository;

import com.ywxiang.mall.portal.domain.MemberProductCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 商品收藏Repository
 *
 * @author ywxiang
 * @date 2020/12/3 下午9:11
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection, String> {
    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);

    int deleteByMemberIdAndProductId(Long memberId, Long productId);

    Page<MemberProductCollection> findByMemberId(Long memberId, Pageable pageable);

    void deleteAllByMemberId(Long memberId);
}
