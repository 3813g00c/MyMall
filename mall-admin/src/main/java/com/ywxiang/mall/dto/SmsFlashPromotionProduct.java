package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.PmsProduct;
import com.ywxiang.mall.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 *
 * @author ywxiang
 * @date 2020/9/12 下午3:27
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProduct product;
}
