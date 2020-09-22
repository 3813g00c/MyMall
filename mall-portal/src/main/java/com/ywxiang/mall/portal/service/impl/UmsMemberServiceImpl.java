package com.ywxiang.mall.portal.service.impl;

import com.ywxiang.mall.mapper.UmsMemberMapper;
import com.ywxiang.mall.model.UmsMember;
import com.ywxiang.mall.model.UmsMemberExample;
import com.ywxiang.mall.portal.domain.MemberDetails;
import com.ywxiang.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/9/16 下午9:27
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UmsMember member = getByUsername(username);
        if (member != null) {
            return new MemberDetails(member);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public UmsMember getByUsername(String username) {
        UmsMember member = null;
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            member = memberList.get(0);
            return member;
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return null;
    }

    @Override
    public void register(String username, String password, String telephone, String authCode) {

    }

    @Override
    public void updatePassword(String telephone, String password, String authCode) {

    }

    @Override
    public String generateAuthCode(String telephone) {
        return null;
    }

    @Override
    public UmsMember getCurrentMember() {
        return null;
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {

    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }
}
