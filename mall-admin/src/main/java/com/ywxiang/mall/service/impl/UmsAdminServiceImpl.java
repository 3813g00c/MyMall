package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.mapper.UmsAdminMapper;
import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsAdminExample;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:32
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    UmsAdminMapper adminMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return null;
    }
}
