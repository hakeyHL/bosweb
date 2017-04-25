package com.bos.controller;

import com.bos.model.User;
import com.bos.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by linux on 2017年04月23日.
 * Time 16:27
 */
@RequestMapping("user")
@Controller
public class UserController extends BaseController {
    @Resource
    UserService userService;

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping("to/register")
    private ModelAndView toRegisterPage() {
        modelAndView.setViewName("layout/user/register");
        return modelAndView;
    }


    @RequestMapping("register")
    private ModelAndView registerUser(User user) {
        int id = userService.saveUser(user);
        if (id > 0) {
            modelAndView.addObject("msg", "注册成功!");
        }
        removeUserFromSession();
        modelAndView.setViewName("layout/user/login");
        //注册成功显示一个提示然后跳转到登录页面
        return modelAndView;
    }


    @RequestMapping("logout")
    private ModelAndView logout() {
        modelAndView.setViewName("layout/user/login");
        removeUserFromSession();
        return modelAndView;
    }

    @RequestMapping("login")
    private ModelAndView login(User user) {
        //验证码校验
        //查询用户
        User loginUser = userService.getUserByName(user.getUsername());
        if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
            //只能有一个
            modelAndView.addObject("msg", "ok");
            modelAndView.setViewName("/index");
            request.getSession().setAttribute("user", loginUser);
        } else {
            modelAndView.addObject("msg", "用户名或密码错误!");
            modelAndView.addObject("data", user);
            modelAndView.setViewName("layout/user/login");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("validate")
    private Map validate(String userName) {
        Map dataMap = new HashMap();
        dataMap.put("valid", true);
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(userName)) {
            User user = userService.getUserByName(userName);
            if (user != null) {
                dataMap.put("valid", false);
            }
        }
        return dataMap;
    }
}
