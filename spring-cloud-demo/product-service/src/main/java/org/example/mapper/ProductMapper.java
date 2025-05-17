package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.model.ProductInfo;

@Mapper
public interface ProductMapper {
    @Select("select * from product_detail where id = #{id}")
    ProductInfo selectProductById(Integer id);
}
