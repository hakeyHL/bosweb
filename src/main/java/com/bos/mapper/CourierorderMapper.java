package com.bos.mapper;

import com.bos.model.Courierorder;
import com.bos.model.CourierorderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CourierorderMapper {
    int countByExample(CourierorderExample example);

    int deleteByExample(CourierorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courierorder record);

    int insertSelective(Courierorder record);

    List<Courierorder> selectByExampleWithRowbounds(CourierorderExample example, RowBounds rowBounds);

    List<Courierorder> selectByExample(CourierorderExample example);

    Courierorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courierorder record, @Param("example") CourierorderExample example);

    int updateByExample(@Param("record") Courierorder record, @Param("example") CourierorderExample example);

    int updateByPrimaryKeySelective(Courierorder record);

    int updateByPrimaryKey(Courierorder record);
}