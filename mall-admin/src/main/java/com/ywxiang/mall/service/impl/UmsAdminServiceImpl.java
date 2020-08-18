package com.ywxiang.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.ywxiang.mall.dao.UmsAdminRoleRelationDao;
import com.ywxiang.mall.mapper.UmsAdminMapper;
import com.ywxiang.mall.model.UmsAdmin;
import com.ywxiang.mall.model.UmsAdminExample;
import com.ywxiang.mall.model.UmsRole;
import com.ywxiang.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if (!StringUtils.isEmpty(keyword)){
            criteria.andUsernameLike("%" + keyword + "%");
            adminExample.or(adminExample.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        List<UmsAdmin> adminList = adminMapper.selectByExample(adminExample);
        for (UmsAdmin admin : adminList){
            admin.setPassword(null);
        }
        return adminList;
    }
}
