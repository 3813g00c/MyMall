package com.ywxiang.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品分类对应属性信息
 *
 * @author ywxiang
 * @date 2020/9/1 下午10:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductAttributeInfo {
    @ApiModelProperty("商品属性ID")
    private Long attributeId;

    @ApiModelProperty("商品属性分类ID")
    private Long attributeCategoryId;
}
