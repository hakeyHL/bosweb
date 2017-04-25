package com.bos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/layout")
public class ShowHomeController extends BaseController {

    @RequestMapping("/showIndex")
    public ModelAndView showMain() {
        //跳转到WEB-INF/jsp/views/layout/index.jsp页面
        removeUserFromSession();
        return new ModelAndView("layout/index");
    }
}
