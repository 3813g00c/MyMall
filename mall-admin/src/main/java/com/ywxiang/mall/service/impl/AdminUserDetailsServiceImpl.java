package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.bo.AdminUserDetails;
import com.ywxiang.mall.mapper.UmsAdminMapper;
import com.ywxiang.mall.mapper.UmsAdminRoleRelationDao;
import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsAdminExample;
import com.ywxiang.mall.model.UmsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/8 下午1:37
 */
@Service
public class AdminUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Autowired
    UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(s);
        List<UmsAdmin> adminList = umsAdminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            UmsAdmin admin = adminList.get(0);
            List<UmsResource> resourcesList = umsAdminRoleRelationDao.getResourceList(admin.getId());

            AdminUserDetails adminUserDetails = new AdminUserDetails(admin, resourcesList);
            return adminUserDetails;
        }
        return null;
    }
}
