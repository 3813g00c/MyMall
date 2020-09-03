package com.ywxiang.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Oss上传成功回调参数
 *
 * @author ywxiang
 * @date 2020/9/3 下午8:57
 */
@Data
public class OssCallbackParam {
    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;

    @ApiModelProperty("回调是传入request中的参数")
    private String callbackBody;

    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;

}
