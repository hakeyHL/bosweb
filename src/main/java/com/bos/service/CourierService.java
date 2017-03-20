package com.bos.service;

import com.bos.mapper.CourierMapper;
import com.bos.model.Courier;
import com.bos.model.CourierExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linux on 2017年03月18日.
 * Time 09:17
 */
@Service
public class CourierService {
    @Resource
    private CourierMapper courierMapper;

    /**
     * 获取Courier列表
     *
     * @return 快递员列表
     */
    public List<Courier> listCouriers(String keyword) {
        CourierExample courierExample = new CourierExample();
        CourierExample.Criteria criteria = courierExample.createCriteria();
        criteria.andIdIsNotNull();
        if (StringUtils.isNoneEmpty(keyword)) {
            criteria.andNameLike(keyword + "%");
        }
        return courierMapper.selectByExample(courierExample);
    }

    /**
     * 添加
     *
     * @param courier
     */
    public void addCourier(Courier courier) {
        courierMapper.insert(courier);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delCourier(int id) {
        //根据主键删除
        courierMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param courier
     */
    public void updateCourier(Courier courier) {
        //根据主键更新
        courierMapper.updateByPrimaryKey(courier);
    }

    /**
     * 根据主键id获取快递员信息
     *
     * @param id 主键id
     * @return 快递员完整信息
     */
    public Courier getCourierById(int id) {
        //根据主键获取快递员信息
        return courierMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    //开启事务
    @Transactional
    public void batchDelCourier(@RequestBody int[] ids) {
        for (int id : ids) {
            //根据主键删除
            courierMapper.deleteByPrimaryKey(id);
        }
    }
}
