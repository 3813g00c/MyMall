package com.ywxiang.mall.dto;

import com.ywxiang.mall.model.OmsCompanyAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 *
 * @author ywxiang
 * @date 2020/9/12 下午2:08
 */
public class OmsOrderReturnApplyResult {

    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
