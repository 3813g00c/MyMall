package com.ywxiang.mall.service.impl;

import com.ywxiang.mall.dao.UmsRoleDao;
import com.ywxiang.mall.mapper.UmsRoleMapper;
import com.ywxiang.mall.model.UmsMenu;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.model.UmsRoleExample;
import com.ywxiang.mall.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:59
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    UmsRoleDao roleDao;

    @Autowired
    UmsRoleMapper roleMapper;

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }
}
