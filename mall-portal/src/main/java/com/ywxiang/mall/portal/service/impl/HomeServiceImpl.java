package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.mapper.SmsFlashPromotionMapper;
import com.ywxiang.mall.mapper.SmsFlashPromotionSessionMapper;
import com.ywxiang.mall.mapper.SmsHomeAdvertiseMapper;
import com.ywxiang.mall.model.*;
import com.ywxiang.mall.portal.dao.HomeDao;
import com.ywxiang.mall.portal.domain.FlashPromotionProduct;
import com.ywxiang.mall.portal.domain.HomeContentResult;
import com.ywxiang.mall.portal.domain.HomeFlashPromotion;
import com.ywxiang.mall.portal.service.HomeService;
import com.ywxiang.mall.portal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/16 下午9:58
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        result.setAdvertiseList(getHomeAdvertiseList());
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        result.setBrandList(homeDao.getRecommendBrandList(0, 6));
        result.setNewProductList(homeDao.getNewProductList(0, 6));
        result.setHotProductList(homeDao.getHotProductList(0, 6));
        result.setSubjectList(homeDao.getRecommendSubjectList(0, 6));
        return result;
    }

    /**
     * 获取轮播广告列表
     *
     * @return
     */
    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    /**
     * 获取首页秒杀场次信息
     *
     * @return
     */
    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        // 获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            // 获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                // 获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if (nextSession != null) {
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                // 获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;

    }

    /**
     * 根据时间活动秒杀活动
     *
     * @param date
     * @return
     */
    private SmsFlashPromotion getFlashPromotion(Date date) {
        Date currDate = DateUtil.getDate(date);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currDate)
                .andEndDateGreaterThanOrEqualTo(currDate);
        List<SmsFlashPromotion> flashPromotions = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotions)) {
            return flashPromotions.get(0);
        }
        return null;
    }

    /**
     * 根据时间活动秒杀场次
     *
     * @param date
     * @return
     */
    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    /**
     * 获取下一个秒杀场次信息
     *
     * @param date
     * @return
     */
    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStartTimeGreaterThan(date);
        example.setOrderByClause("start_time asc");
        List<SmsFlashPromotionSession> promotionSessions = promotionSessionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(promotionSessions)) {
            return promotionSessions.get(0);
        }
        return null;
    }
}
