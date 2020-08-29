package com.ywxiang.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品查询参数
 *
 * @author ywxiang
 * @date 2020/8/29 下午3:27
 */
@Getter
@Setter
public class PmsProductQueryParam {

    @ApiModelProperty("上架状态")
    private Integer publishStatus;

    @ApiModelProperty("审核状态")
    private Integer verifyStatus;

    @ApiModelProperty("商品名称模糊关键字")
    private String keyword;

    @ApiModelProperty("商品货号")
    private String productSn;

    @ApiModelProperty("商品分类编号")
    private Long productCategoryId;

    @ApiModelProperty("商品品牌编号")
    private Long brandId;
}
