package org.example.mapper;

import org.example.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from order_detail where id=#{orderId}")
    OrderInfo selectOrderById(Integer orderId);
}
