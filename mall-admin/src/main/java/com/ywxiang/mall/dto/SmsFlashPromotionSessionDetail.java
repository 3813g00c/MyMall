package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:22
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {
    @Setter
    @Getter
    @ApiModelProperty("商品数量")
    private Long productCount;
}
