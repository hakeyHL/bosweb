package com.bos.service;

import com.bos.mapper.OrderMapper;
import com.bos.model.Order;
import com.bos.model.OrderExample;
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
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 获取Order列表
     *
     * @return 订单列表
     */
    public List<Order> listOrders(String keyword) {
        OrderExample OrderExample = new OrderExample();
        com.bos.model.OrderExample.Criteria criteria = OrderExample.createCriteria();
        criteria.andIdIsNotNull();
        if (StringUtils.isNotEmpty(keyword)) {
            criteria.andSenderLike(keyword + "%");
        }
        return orderMapper.selectByExample(OrderExample);
    }

    /**
     * 添加
     *
     * @param Order
     */
    public void addOrder(Order Order) {
        orderMapper.insert(Order);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    public void delOrder(int id) {
        //根据主键删除
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新
     *
     * @param order
     */
    public void updateOrder(Order order) {
        //根据主键更新
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 根据主键id获取订单信息
     *
     * @param id 主键id
     * @return 订单完整信息
     */
    public Order getOrderById(int id) {
        //根据主键获取订单信息
        return orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取快递员负责的订单列表
     *
     * @param id
     * @return
     */
    public List<Order> getOrdersByCourierId(int id) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andCourieridEqualTo(id);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        return orders;
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
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}
