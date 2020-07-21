package com.aladdin.shiro.service;

import com.aladdin.shiro.entity.auto.User;
import com.aladdin.shiro.entity.dto.UserRolePers;

import java.util.Optional;

/**
 * @author lgc
 */
public interface UserService {
    void registerUser(User user);

    Optional<User> findByUserName(String userName);

    UserRolePers findRoleByUserName(String userName);
}
