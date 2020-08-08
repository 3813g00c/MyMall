package com.ywxiang.mall.mapper;

import com.ywxiang.mall.model.UmsPermission;
import com.ywxiang.mall.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台用户与角色管理
 * @author ywxiang
 * @date 2020/8/8 下午11:25
 */
@Mapper
public interface UmsAdminRoleRelationDao {
    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);
}
