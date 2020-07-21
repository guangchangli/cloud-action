package com.aladdin.shiro.shiro.realms;

import com.aladdin.shiro.config.ApplicationContextUtil;
import com.aladdin.shiro.entity.auto.Perms;
import com.aladdin.shiro.entity.auto.User;
import com.aladdin.shiro.entity.dto.RoleDto;
import com.aladdin.shiro.entity.dto.UserRolePers;
import com.aladdin.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lgc
 */
@Slf4j
public class CustomerRealm extends AuthorizingRealm {

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //在token 中获取用户名
        String principal = (String) authenticationToken.getPrincipal();
        log.info("login -- token: " + principal);
        //根据身份信息查询数据
        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        Optional<User> user = userService.findByUserName(principal);
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        if (user.isPresent()) {
            User u = user.get();
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(u.getUserName(), u.getPassword(), ByteSource.Util.bytes(u.getSalt()), getName());
        }
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * add/set
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        UserRolePers userRolePers = userService.findRoleByUserName(primaryPrincipal);
        if (userRolePers == null) return null;
        List<RoleDto> roles = userRolePers.getRoles();
        //用户角色权限信息 获取频繁
        if (roles.size() > 0) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setRoles(roles.stream().map(RoleDto::getName).collect(Collectors.toSet()));
            Set<List<Perms>> collect = roles.stream().map(RoleDto::getPermsList).collect(Collectors.toSet());
            Set<String> permSet = new HashSet<>(16);
            for (List<Perms> perms : collect) {
                permSet.addAll(perms.stream().map(Perms::getUrl).collect(Collectors.toSet()));
            }
            simpleAuthorizationInfo.setStringPermissions(permSet);
            return simpleAuthorizationInfo;
        }
        return null;
    }
}
