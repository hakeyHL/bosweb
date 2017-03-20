package com.bos.controller;

import com.bos.model.Car;
import com.bos.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linux on 2017年03月18日.
 * Time 09:02
 */
@Controller
@RequestMapping("car")//请求路径映射
public class CarController extends BaseController {
    //注入service
    @Resource
    private CarService carService;

    //请求路径映射,加上类上的此注解,此接口的完整访问路径为
    //ip:端口/Car/list
    @RequestMapping("list")
    //获取车辆列表
    public ModelAndView listCars() {
        List<Car> cars = carService.listCars();
        modelAndView.addObject("cars", cars);
        modelAndView.setViewName("layout/car/list");
        return modelAndView;
    }

    //增加一个车辆
    @RequestMapping("add")
    public ModelAndView addCar(Car car) {
        carService.addCar(car);
        //增加完之后返回车辆列表页面,所以调用本类listCars方法
        return this.listCars();
    }


    //删除一个车辆
    @RequestMapping("del/{id}")
    public ModelAndView delCar(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到车辆列表页面
            return this.listCars();
        }
        carService.delCar(id);
        //增加完之后返回车辆列表页面,所以调用本类listCars方法
        return this.listCars();
    }

    //修改车辆信息
    @RequestMapping("update")
    public ModelAndView updateCar(Car car) {
        if (car == null || car.getId() <= 0) {
            //如果传来的id小于等于0或对象为空则无法操作,直接跳转到车辆列表页面
            return this.listCars();
        }
        carService.updateCar(car);
        //增加完之后返回车辆列表页面,所以调用本类listCars方法
        return this.listCars();
    }

    /**
     * 获取车辆信息
     *
     * @param id 车辆id
     */
    @RequestMapping("info/{id}")
    public ModelAndView getCarInfo(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到车辆列表页面
            return this.listCars();
        }
        Car Car = carService.getCarById(id);
        modelAndView.addObject("Car", Car);
        modelAndView.setViewName("layout/car/edit");
        return modelAndView;
    }
}
