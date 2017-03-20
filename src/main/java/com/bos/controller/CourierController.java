package com.bos.controller;

import com.bos.model.Courier;
import com.bos.model.Order;
import com.bos.service.CourierService;
import com.bos.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linux on 2017年03月18日.
 * Time 09:02
 */
@Controller
@RequestMapping("courier")//请求路径映射
public class CourierController extends BaseController {
    //注入service
    @Resource
    private CourierService courierService;
    @Resource
    private OrderService orderService;

    //请求路径映射,加上类上的此注解,此接口的完整访问路径为
    //ip:端口/courier/list
    @RequestMapping("list")
    //获取快递员列表
    public ModelAndView listCouriers() {
        String keyword = request.getParameter("keyword");
        List<Courier> couriers = courierService.listCouriers(keyword);
        modelAndView.addObject("couriers", couriers);
        modelAndView.setViewName("layout/courier/list");
        return modelAndView;
    }

    //增加一个快递员
    @RequestMapping("add")
    public ModelAndView addCourier(Courier courier) {
        courierService.addCourier(courier);
        //增加完之后返回快递员列表页面,所以调用本类listCouriers方法
        return this.listCouriers();
    }


    //删除一个快递员
    @RequestMapping("del/{id}")
    public ModelAndView delCourier(@PathVariable(value = "id") int id) {
        courierService.delCourier(id);
        //返回快递员列表页面,所以调用本类listCouriers方法
        return this.listCouriers();
    }

    //删除多个快递员
    @ResponseBody
    @RequestMapping("batchDelete")
    public boolean batchDelCourier(@RequestParam(value = "ids[]") int[] ids) {
        courierService.batchDelCourier(ids);
        return true;
    }

    //修改快递员信息
    @RequestMapping("update")
    public ModelAndView updateCourier(Courier courier) {
        if (courier.getId() == null) {
            this.addCourier(courier);
        } else {
            courierService.updateCourier(courier);
        }
        //返回快递员列表页面,所以调用本类listCouriers方法
        return this.listCouriers();
    }

    /**
     * 获取快递员信息
     *
     * @param id 快递员id
     */
    @RequestMapping("info/{id}")
    public ModelAndView getCourierInfo(@PathVariable(value = "id") int id) {
        modelAndView.setViewName("layout/courier/edit");
        if (id <= 0) {
            //如果id小于等于0跳转到编辑页面,表示添加快递员
            return modelAndView;
        }
        Courier courier = courierService.getCourierById(id);
        modelAndView.addObject("courier", courier);

        List<Order> orders = orderService.getOrdersByCourierId(id);
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
