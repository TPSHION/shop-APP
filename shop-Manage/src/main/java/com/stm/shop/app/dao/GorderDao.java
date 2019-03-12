package com.stm.shop.app.dao;

import com.stm.shop.entity.Gorder;
import com.stm.shop.entity.GorderAssociation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GorderDao {
    int deleteByPrimaryKey(@Param("gorderId")Integer gorderId);

    int insert(Gorder record);

    int insertSelective(Gorder record);

   List<GorderAssociation> selectByPrimaryKey(@Param("gorderId")Integer gorderId);

    int updateByPrimaryKeySelective(Gorder record);

    int updateByPrimaryKey(Gorder record);

    List<Gorder> selectAll(@Param("userId")Integer id);

    Integer orderChangeState(@Param("gorderId") Integer gorderId, @Param("gorderState") Integer state);

    //添加订单
    int insertGorder(Gorder gorder);
}