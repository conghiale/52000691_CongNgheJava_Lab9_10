package com.example._52000691Lab9.iservice;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    Product selectById(Integer id);
    Product insert(Product product);
    boolean deleteById(Integer id);
    Product update(Product productUpdate);
    List<Product> searchByPrice(Double price);
}
