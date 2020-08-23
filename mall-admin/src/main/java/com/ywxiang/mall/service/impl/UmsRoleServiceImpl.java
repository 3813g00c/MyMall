package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.UmsRoleDao;
import com.ywxiang.mall.mapper.UmsRoleMapper;
import com.ywxiang.mall.model.UmsMenu;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.model.UmsRoleExample;
import com.ywxiang.mall.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public List<UmsRole> listByPage(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample example = new UmsRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }
}
