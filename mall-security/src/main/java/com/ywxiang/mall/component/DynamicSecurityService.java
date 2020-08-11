package com.ywxiang.mall.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限业务类
 * @author ywxiang
 * @date 2020/8/11 下午8:08
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     *
     * @return
     */
    Map<String, ConfigAttribute> loadDataSource();
}
