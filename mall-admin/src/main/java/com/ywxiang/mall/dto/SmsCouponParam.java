package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.SmsCoupon;
import com.ywxiang.mall.model.SmsCouponProductCategoryRelation;
import com.ywxiang.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 *
 * @author ywxiang
 * @date 2020/9/5 下午4:47
 */
public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;

    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
