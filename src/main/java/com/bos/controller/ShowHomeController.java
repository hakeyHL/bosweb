package com.bos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/layout")
public class ShowHomeController {

    @RequestMapping("/showIndex")
    public ModelAndView showMain() {
        return new ModelAndView("layout/index");
    }

}
