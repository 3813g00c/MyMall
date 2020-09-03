package com.ywxiang.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ywxiang
 * @date 2020/9/3 下午8:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;

    @ApiModelProperty("文件大小")
    private String size;

    @ApiModelProperty("文件的mimeType")
    private String mimeType;

    @ApiModelProperty("图片文件的宽")
    private String width;

    @ApiModelProperty("图片文件的高")
    private String height;
}
