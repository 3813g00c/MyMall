package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品层级查询dto
 * @author ywxiang
 * @date 2020/8/30 下午3:00
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory{
    @Getter
    @Setter
    @ApiModelProperty("子集分类")
    private List<PmsProductCategory> children;
}
