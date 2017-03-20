package com.bos.mapper;

import com.bos.model.Courier;
import com.bos.model.CourierExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CourierMapper {
    int countByExample(CourierExample example);

    int deleteByExample(CourierExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courier record);

    int insertSelective(Courier record);

    List<Courier> selectByExampleWithRowbounds(CourierExample example, RowBounds rowBounds);

    List<Courier> selectByExample(CourierExample example);

    Courier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courier record, @Param("example") CourierExample example);

    int updateByExample(@Param("record") Courier record, @Param("example") CourierExample example);

    int updateByPrimaryKeySelective(Courier record);

    int updateByPrimaryKey(Courier record);
}