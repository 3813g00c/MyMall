package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.PmsProductAttribute;
import com.ywxiang.mall.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 *
 * @author ywxiang
 * @date 2020/9/4 下午8:05
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
