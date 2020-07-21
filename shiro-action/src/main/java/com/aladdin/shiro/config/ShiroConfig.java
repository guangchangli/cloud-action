package com.aladdin.shiro.config;

import com.aladdin.shiro.shiro.cache.RedisCacheManager;
import com.aladdin.shiro.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lgc
 */
@Configuration
public class ShiroConfig {
    /**
     * 1.shiroFilter 负责拦截所有请求
     * 2.安全管理器
     * 3.自定义realm
     *
     * @return web shiro Filter
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源｜公共资源
        Map<String, String> map = new HashMap<>(16);
        //authc 需要认证和授权
        //匿名访问
        map.put("/html/*","anon");
        map.put("/jsp/register.jsp","anon");
        map.put("/jsp/upload.jsp","anon");
        map.put("/edit/pa","anon");
        map.put("/edit/index","anon");
        map.put("/go/upload","anon");
        map.put("/go/index","anon");
        map.put("/actuator/*", "anon");
        map.put("/user/register", "anon");
        map.put("/user/login", "anon");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //默认认证界面路径 302 -> login.jsp
        shiroFilterFactoryBean.setLoginUrl("/jsp/login.jsp");

        return shiroFilterFactoryBean;

    }

    /**
     * 注册web 安全管理器
     *
     * @param realm realm 认证授权数据处理
     * @return webSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //安全管理器设置realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * 注册 realm
     *
     * @return realm
     */
    @Bean
    @Primary
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        //缓存设置
        customerRealm.setCacheManager(new RedisCacheManager());
        //全局缓存
        customerRealm.setCachingEnabled(true);
        //认证缓存
        customerRealm.setAuthenticationCachingEnabled(true);
        customerRealm.setAuthenticationCacheName("authenticationCache");
        //授权缓存
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setAuthorizationCacheName("authorizationCache");
        /**
         * Cache<Object, AuthorizationInfo> authorizationCache
         */

        return customerRealm;
    }

    /**
     * 注册凭证匹配器
     *
     * @return credentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        return hashedCredentialsMatcher;
    }
}
