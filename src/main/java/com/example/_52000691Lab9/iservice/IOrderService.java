package com.example._52000691Lab9.iservice;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.Product;

import java.util.List;

public interface IOrderService {
    List<Order> selectAll();
    Order selectById(Integer id);
    Order insert(Order order);
    boolean deleteById(Integer id);
    Order update(Order orderUpdate);
    List<Product> findProductsByOrderId(Integer orderId);
    List<Order> searchByTotalPrice(Double totalPrice);
}
