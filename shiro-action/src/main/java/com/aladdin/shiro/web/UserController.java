package com.aladdin.shiro.web;

import com.aladdin.shiro.entity.auto.User;
import com.aladdin.shiro.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author lgc
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/")
    public String index(){
        return "/jsp/index.jsp";
    }

    @PostMapping("login")
    public String login(String username, String password) {
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/jsp/index.jsp";
        } catch (UnknownAccountException e) {
            log.error("{}--用户名错误", username);

        } catch (IncorrectCredentialsException e) {
            log.error("{}_{} ---密码错误", username, password);
        }
        return "redirect:/jsp/login.jsp";
    }

    @GetMapping("logout")
    public String out() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/jsp/login.jsp";
    }

    @PostMapping("register")
//    @RequiresRoles(value = {"admin,user"})
//    @RequiresPermissions("user:update:01")
    public String register(User user) {
        try {
            userService.registerUser(user);
            redisTemplate.opsForValue().set(user.getUserName(),user.getPassword());
            return "/jsp/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/jsp/register.jsp";
        }
    }

    @GetMapping("getUserByName")
    @ResponseBody
    public String findUserByName(@RequestParam("userName") String userName) {
        Optional<User> user = userService.findByUserName(userName);
        Gson gson = new Gson();
        return gson.toJson(user.get());
    }
    @GetMapping("redis")
    @ResponseBody
    public String redis(){
        redisTemplate.opsForValue().setIfAbsent("aa","aa");
        Object aa = redisTemplate.opsForValue().get("aa");
        return aa.toString();
    }
}
