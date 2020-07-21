package com.aladdin.shiro.service.impl;

import com.aladdin.shiro.dao.auto.UserMapper;
import com.aladdin.shiro.entity.auto.User;
import com.aladdin.shiro.entity.dto.UserRolePers;
import com.aladdin.shiro.service.UserService;
import com.aladdin.shiro.util.SaltUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author lgc
 */
@Service("userService")
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        String salt = SaltUtil.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        userMapper.saveUser(user);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name",userName);
        return Optional.ofNullable(userMapper.selectOne(qw));
    }

    @Override
    public UserRolePers findRoleByUserName(String userName) {
        return userMapper.findRolesByUserName(userName);
    }
}
