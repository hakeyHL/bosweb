package com.bos.controller;

import com.bos.model.Car;
import com.bos.model.Courier;
import com.bos.model.Order;
import com.bos.service.CarService;
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
 * Time 09:03
 */
@Controller
@RequestMapping("order")//请求路径映射
public class OrderController extends BaseController {
    //注入service
    @Resource
    private OrderService orderService;
    @Resource
    private CourierService courierService;
    @Resource
    private CarService carService;

    //请求路径映射,加上类上的此注解,此接口的完整访问路径为
    //ip:端口/Order/list
    @RequestMapping("list")
    //获取订单列表
    public ModelAndView listOrders() {
        String keyword = request.getParameter("keyword");
        //获取订单列表
        List<Order> orders = orderService.listOrders(keyword);
        modelAndView.addObject("orders", orders);

        //查询快递员表与车辆表获取快递员名称和车辆编号
        for (Order order : orders) {
            //根据快递员id获取快递员
            Courier courier = courierService.getCourierById(order.getCourierid());
            if (courier != null) {
                order.setCourierName(courier.getName());
            }
            //根据车辆id获取车辆编号
            Car car = carService.getCarById(order.getCarnumber());
            if (car != null) {
                order.setVehicleNumber(car.getNumber());
            }
        }
        modelAndView.setViewName("layout/order/list");
        return modelAndView;
    }

    //增加一个订单
    @RequestMapping("add")
    public ModelAndView addOrder(Order order) {
        orderService.addOrder(order);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return this.listOrders();
    }


    //删除一个订单
    @RequestMapping("del/{id}")
    public ModelAndView delOrder(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到订单列表页面
            return this.listOrders();
        }
        orderService.delOrder(id);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return this.listOrders();
    }

    //修改订单信息
    @RequestMapping("update")
    public ModelAndView updateOrder(Order order) {
        if (order == null || order.getId() == null) {
            //如果传来的id小于等于0或对象为空则无法操作,直接跳转到订单列表页面
            return this.listOrders();
        }
        orderService.updateOrder(order);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return this.listOrders();
    }

    /**
     * 获取订单信息
     *
     * @param id 订单id
     */
    @RequestMapping("info/{id}")
    public ModelAndView getOrderInfo(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到订单列表页面
            return this.listOrders();
        }
        Order Order = orderService.getOrderById(id);
        modelAndView.addObject("Order", Order);
        modelAndView.setViewName("layout/order/edit");
        return modelAndView;
    }

    /**
     * \删除多个订单
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("batchDelete")
    public boolean batchDelCourier(@RequestParam(value = "ids[]") int[] ids) {
        orderService.batchDelCourier(ids);
        return true;
    }
}
