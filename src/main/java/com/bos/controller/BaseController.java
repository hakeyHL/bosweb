package com.bos.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linux on 2017年03月18日.
 * Time 09:00
 */
public abstract class BaseController {
    protected ModelAndView modelAndView = new ModelAndView();
    protected HttpServletRequest request;

    /*
    * 注解ModelAttribute的意义是
    * 被注解的方法会在进入每个controller之前执行
    * */
    @ModelAttribute
    private void init(HttpServletRequest request) {
        //将modelAndView中属性清空
        modelAndView.clear();
        //赋值request和response对象,以便获取request中的属性
        this.request = request;
    }
}
