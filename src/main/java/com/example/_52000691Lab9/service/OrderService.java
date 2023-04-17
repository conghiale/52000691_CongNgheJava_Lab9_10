package com.example._52000691Lab9.service;

import com.example._52000691Lab9.iservice.IOrderService;
import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> selectAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order selectById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (orderRepository.existsById(id))
            orderRepository.deleteById(id);
        return !orderRepository.existsById(id);
    }

    @Override
    public Order update(Order orderUpdate) {
        return orderRepository.save(orderUpdate);
    }
    @Override
    public List<Product> findProductsByOrderId(Integer orderId) {
        return orderRepository.findProductsByOrderId(orderId);
    }

    @Override
    public List<Order> searchByTotalPrice(Double totalPrice) {
        return orderRepository.searchByTotalPrice(totalPrice);
    }
}
