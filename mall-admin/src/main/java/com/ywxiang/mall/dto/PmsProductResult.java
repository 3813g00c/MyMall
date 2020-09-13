package com.ywxiang.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询单个商品进行修改时返回的数据
 *
 * @author ywxiang
 * @date 2020/9/13 下午1:17
 */
public class PmsProductResult extends PmsProductParam {

    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
