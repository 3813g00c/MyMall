package com.ywxiang.mall.service;

import com.ywxiang.mall.dto.SmsFlashPromotionSessionDetail;
import com.ywxiang.mall.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * 限时购场次管理Service
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:19
 */
public interface SmsFlashPromotionSessionService {

    /**
     * 添加场次
     *
     * @param promotionSession
     * @return
     */
    int create(SmsFlashPromotionSession promotionSession);

    /**
     * 修改场次
     *
     * @param id
     * @param promotionSession
     * @return
     */
    int update(Long id, SmsFlashPromotionSession promotionSession);

    /**
     * 修改启用状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Long id, Integer status);

    /**
     * 删除场次
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * 根据启用状态获取场次列表
     *
     * @return
     */
    List<SmsFlashPromotionSession> list();

    /**
     * 获取全部可选场次及数量
     *
     * @param flashPromotionId
     * @return
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
