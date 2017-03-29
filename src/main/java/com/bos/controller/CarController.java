package com.bos.controller;

import com.bos.model.Car;
import com.bos.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    //ip:端口/car/list
    @RequestMapping("list")
    //获取车辆列表
    public ModelAndView listCars(Car car) {
        if (car != null) {
            modelAndView.addObject("car", car);
        }
        List<Car> cars = carService.listCars(car);
        modelAndView.addObject("cars", cars);
        modelAndView.setViewName("layout/car/list");
        return modelAndView;
    }

    //增加一个车辆
    @RequestMapping("add")
    public ModelAndView addCar(Car car) {
        carService.addCar(car);
        //增加完之后返回车辆列表页面,所以调用本类listCars方法
        return this.listCars(new Car());
    }


    //删除一个车辆
    @RequestMapping("del/{id}")
    public ModelAndView delCar(@PathVariable(value = "id") int id) {
        if (id <= 0) {
            //如果传来的id小于等于0则无法操作,直接跳转到车辆列表页面
            return this.listCars(new Car());
        }
        carService.delCar(id);
        //增加完之后返回车辆列表页面,所以调用本类listCars方法
        return this.listCars(new Car());
    }

    //删除多个车辆
    @ResponseBody
    @RequestMapping("batchDelete")
    public boolean batchDelCourier(@RequestParam(value = "ids[]") int[] ids) {
        carService.batchDelCar(ids);
        return true;
    }

    //修改车辆信息
    @RequestMapping("update")
    public RedirectView updateCar(Car car) {
        if (car.getId() == null) {
            this.addCar(car);
        } else {
            carService.updateCar(car);
        }
        //重定向到车辆列表页面
        return new RedirectView("/car/list");
    }

    /**
     * 获取车辆信息
     *
     * @param id 车辆id
     */
    @RequestMapping("info/{id}")
    public ModelAndView getCarInfo(@PathVariable(value = "id") int id) {
        modelAndView.setViewName("layout/car/edit");
        if (id <= 0) {
            return modelAndView;
        }
        Car Car = carService.getCarById(id);
        modelAndView.addObject("car", Car);
        return modelAndView;
    }
}
