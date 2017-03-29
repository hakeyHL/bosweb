package com.bos.service;

import com.bos.mapper.CarMapper;
import com.bos.model.Car;
import com.bos.model.CarExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linux on 2017年03月18日.
 * Time 09:17
 */
@Service
public class CarService {
    @Resource
    private CarMapper carMapper;

    /**
     * 获取Car列表
     *
     * @return 车辆列表
     */
    public List<Car> listCars(Car car) {
        CarExample CarExample = new CarExample();
        com.bos.model.CarExample.Criteria criteria = CarExample.createCriteria();
        criteria.andIdIsNotNull();
        //根据车的品牌
        if (StringUtils.isNotEmpty(car.getBrand())) {
            criteria.andBrandLike("%" + car.getBrand() + "%");
        }
        //根据车的型号
        if (StringUtils.isNotEmpty(car.getModel())) {
            criteria.andModelLike("%" + car.getModel() + "%");
        }
        //根据车的牌号
        if (StringUtils.isNotEmpty(car.getNumber())) {
            criteria.andNumberLike("%" + car.getNumber() + "%");
        }
        return carMapper.selectByExample(CarExample);
    }

    /**
     * 添加
     *
     * @param Car
     */
    public void addCar(Car Car) {
        carMapper.insert(Car);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delCar(int id) {
        //根据主键删除
        carMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param car
     */
    public void updateCar(Car car) {
        //根据主键更新
        carMapper.updateByPrimaryKey(car);
    }

    /**
     * 根据主键id获取车辆信息
     *
     * @param id 主键id
     * @return 车辆完整信息
     */
    public Car getCarById(int id) {
        //根据主键获取车辆信息
        return carMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void batchDelCar(int[] ids) {
        for (int id : ids) {
            //根据主键删除
            carMapper.deleteByPrimaryKey(id);
        }
    }
}
