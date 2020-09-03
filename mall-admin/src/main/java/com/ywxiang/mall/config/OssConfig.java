package com.ywxiang.mall.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS对象存储相关配置
 *
 * @author ywxiang
 * @date 2020/9/3 下午8:28
 */
@Configuration
public class OssConfig {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Bean
    public OSSClient ossClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}
