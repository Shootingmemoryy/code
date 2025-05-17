package org.example.service;


import org.example.mapper.ProductMapper;
import org.example.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductInfo selectProductById(Integer id){
        return productMapper.selectProductById(id);
    }
}
