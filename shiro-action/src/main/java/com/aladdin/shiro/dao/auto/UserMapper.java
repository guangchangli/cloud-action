package com.aladdin.shiro.dao.auto;
import com.aladdin.shiro.entity.auto.User;
import com.aladdin.shiro.entity.dto.UserRolePers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author lgc
 */
public interface UserMapper extends BaseMapper<User> {

    int saveUser(User user);


    UserRolePers findRolesByUserName(String userName);
}
