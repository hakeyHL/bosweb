package com.bos.controller;

import com.bos.model.Car;
import com.bos.model.Courier;
import com.bos.model.Order;
import com.bos.model.User;
import com.bos.service.CarService;
import com.bos.service.CourierService;
import com.bos.service.OrderService;
import com.bos.service.UserService;
import org.apache.commons.lang.StringUtils;
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
    @Resource
    private UserService userService;

    //请求路径映射,加上类上的此注解,此接口的完整访问路径为
    //ip:端口/order/list
    @RequestMapping("list")
    //获取订单列表
    public ModelAndView listOrders(Order orde) {
        User useUser;
        if (StringUtils.isEmpty(orde.getUserName())) {
            useUser = (User) request.getSession().getAttribute("user");
        } else {
            useUser = userService.getUserByName(orde.getUserName());
        }
        if (useUser != null) {
            orde.setUserid(useUser.getId());
            orde.setUserName(useUser.getUsername());
        }
        modelAndView.addObject("order", orde);
        //获取订单列表
        List<Order> orders = orderService.listOrders(orde);
        modelAndView.addObject("orders", orders);

        //查询快递员表与车辆表获取快递员名称和车辆编号
        for (Order order : orders) {
            //根据快递员id获取快递员
            if (order.getCourierid() != null) {
                getCourierNameForOrder(order);
            }
            //根据车辆id获取车辆编号
            if (order.getCarnumber() != null) {
                getCarNumberForOrder(order);
            }

            //根据用户id获取用户名
            if (order.getUserid() != null && order.getId() > 0) {
                getUserNameFromUser(order);
            }
        }
        modelAndView.setViewName("layout/order/list");
        return modelAndView;
    }


    //增加一个订单
    @RequestMapping("add")
    public ModelAndView addOrder(Order order) {
        User currentUser = getCurrentUser();
        if (currentUser != null) {
            order.setUserid(currentUser.getId());
        }
        orderService.addOrder(order);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return new ModelAndView("success");
    }


    //删除一个订单
    @RequestMapping("del/{id}")
    public ModelAndView delOrder(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到订单列表页面
            return this.listOrders(new Order());
        }
        orderService.delOrder(id);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return this.listOrders(new Order());
    }

    //修改订单信息
    @RequestMapping("update")
    public ModelAndView updateOrder(Order order) {
        if (order == null || order.getId() == null) {
            //如果传来的id小于等于0或对象为空则无法操作,直接跳转到订单列表页面
            return this.listOrders(new Order());
        }
        orderService.updateOrder(order);
        //增加完之后返回订单列表页面,所以调用本类listOrders方法
        return this.listOrders(new Order());
    }


    /**
     * 用户下单完跳转到订单列表
     * 之所以加这个接口是为了隐藏订单列表接口以及用户拦截
     * 具体拦截在spring-mvc.xml中配置
     *
     * @return
     */
    @RequestMapping("to/list")
    public ModelAndView toOrderList() {

        return this.listOrders(new Order());
    }


    /**
     * 跳转到下单页面
     *
     * @return
     */
    @RequestMapping("to")
    public ModelAndView toOrderPage() {

        return new ModelAndView("/index");
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
            return this.listOrders(new Order());
        }
        Order order = orderService.getOrderById(id);
        if (order != null) {
            //根据订单中的车辆的id获取车牌号
            getCarNumberForOrder(order);
            //根据订单中的快递员id获取快递员姓名
            getCourierNameForOrder(order);
            modelAndView.addObject("order", order);
        }
        //获取搜索车辆列表
        List<Car> cars = carService.listCars(new Car());
        //获取所有快递员列表
        List<Courier> couriers = courierService.listCouriers("");
        //将属性放入到modelAndView(可以理解为request域)中,可在页面中取属性
        modelAndView.addObject("allCars", cars);
        modelAndView.addObject("allCouriers", couriers);

        //跳转到WEB-INF/jsp/views/layout/order/edit.jsp页面
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

    /**
     * 根据订单中的车辆id获取车牌号
     *
     * @param order
     */
    private void getCarNumberForOrder(Order order) {
        if (order != null && order.getCarnumber() != null) {
            Car car = carService.getCarById(order.getCarnumber());
            if (car != null) {
                order.setVehicleNumber(car.getNumber());
            }
        }
    }

    /**
     * 根据订单中的快递员id获取快递员姓名
     *
     * @param order
     */
    private void getCourierNameForOrder(Order order) {
        if (order != null && order.getCourierid() != null) {
            Courier courier = courierService.getCourierById(order.getCourierid());
            if (courier != null) {
                order.setCourierName(courier.getName());
            }
        }
    }

    /**
     * 根据订单中的用户id获取用户名
     *
     * @param order
     */
    private void getUserNameFromUser(Order order) {
        if (order != null && order.getUserid() != null) {
            User user = userService.getUserById(order.getUserid());
            if (user != null) {
                order.setUserName(user.getUsername());
            }
        }
    }
}
