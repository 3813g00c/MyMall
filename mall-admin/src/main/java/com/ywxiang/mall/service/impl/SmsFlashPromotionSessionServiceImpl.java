package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dto.SmsFlashPromotionSessionDetail;
import com.ywxiang.mall.model.SmsFlashPromotionSession;
import com.ywxiang.mall.service.SmsFlashPromotionSessionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/12 下午3:23
 */
@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {
    @Override
    public int create(SmsFlashPromotionSession promotionSession) {
        return 0;
    }

    @Override
    public int update(Long id, SmsFlashPromotionSession promotionSession) {
        return 0;
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public SmsFlashPromotionSession getItem(Long id) {
        return null;
    }

    @Override
    public List<SmsFlashPromotionSession> list() {
        return null;
    }

    @Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        return null;
    }
}
