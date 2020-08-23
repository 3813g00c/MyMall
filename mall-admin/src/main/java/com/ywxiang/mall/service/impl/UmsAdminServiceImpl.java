package com.ywxiang.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.UmsAdminRoleRelationDao;
import com.ywxiang.mall.mapper.UmsAdminMapper;
import com.ywxiang.mall.mapper.UmsAdminRoleRelationMapper;
import com.ywxiang.mall.model.*;
import com.ywxiang.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/11 下午9:32
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    UmsAdminMapper adminMapper;

    @Autowired
    UmsAdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample adminExample = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = adminExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            adminExample.or(adminExample.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        List<UmsAdmin> adminList = adminMapper.selectByExample(adminExample);
        for (UmsAdmin admin : adminList) {
            admin.setPassword(null);
        }
        return adminList;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = adminMapper.selectByPrimaryKey(id);
        if (rawAdmin.getPassword().equals(admin.getPassword())) {
            admin.setPassword(null);
        } else {
            if (StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            } else {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
        }
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        // 删除原来的关系
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        // 建立新的关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }
}
