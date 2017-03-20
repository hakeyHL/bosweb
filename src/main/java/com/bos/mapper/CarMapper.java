package com.bos.mapper;

import com.bos.model.Car;
import com.bos.model.CarExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExampleWithRowbounds(CarExample example, RowBounds rowBounds);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}