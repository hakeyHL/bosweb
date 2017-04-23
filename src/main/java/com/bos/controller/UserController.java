package com.bos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by linux on 2017年04月23日.
 * Time 16:27
 */
@RequestMapping("user")
@Controller
public class UserController extends BaseController {
    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping("to/register")
    private ModelAndView toRegisterPage() {
        modelAndView.setViewName("layout/register");
        return modelAndView;
    }


    @RequestMapping("register")
    private ModelAndView registerUser(User user) {
        //信息校验
        if (exist) {
            //valid
            modelAndView.addObject("msg", "失败,ID已注册!");
            modelAndView.setViewName("layout/register");
            modelAndView.addObject("data", user);
            return modelAndView;
        }
        Long id = userService.saveUser(user);
        if (id > 0) {
            modelAndView.addObject("msg", "谢谢您加入我们!");
        }

        modelAndView.setViewName("login");
        //注册成功显示一个提示然后跳转到登录页面

        return modelAndView;
    }


    @RequestMapping("login")
    private ModelAndView login(User user) {
        //验证码校验
        //查询用户
        List<User> users = userService.listAllUser(user);
        if (users != null && users.size() == 1) {
            //只能有一个
            modelAndView.addObject("msg", "ok");
            List<TrainNumber> trainNumbers = trainNumberService.listTrains(new TrainNumber());
            modelAndView.addObject("trains", trainNumbers);

            modelAndView.setViewName("layout/listtrain");
            request.getSession().setAttribute("user", users.get(0));
        } else {
            modelAndView.addObject("msg", "用户名或密码错误!");
            modelAndView.addObject("data", user);
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }


}
