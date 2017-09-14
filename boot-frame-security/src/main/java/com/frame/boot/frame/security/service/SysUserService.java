package com.frame.boot.frame.security.service;

import com.frame.boot.frame.security.authentication.SysSecurityUser;
import com.frame.boot.frame.security.entity.SysUser;
import com.frame.boot.frame.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sysUserService")
public class SysUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = findSecurityUserByUsername(username);
        if (sysUser != null) {
            return new SysSecurityUser(sysUser);
        } else {
            return null;
        }
    }

    public SysUser create(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        sysUserMapper.insert(sysUser);
        return sysUser;
    }

    public SysUser updateByPK(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        sysUserMapper.updateByPrimaryKey(sysUser);
        return sysUser;
    }

    /**
     * 查询用户
     *
     * @param username
     * @return
     */
    public SysUser findByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    /**
     * 查询权限用户
     *
     * @param username
     * @return
     */
    public SysUser findSecurityUserByUsername(String username) {
        return sysUserMapper.findSecurityUserByUsername(username);
    }
}
