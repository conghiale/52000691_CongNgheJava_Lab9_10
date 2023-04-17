package com.example._52000691Lab9.service;

import com.example._52000691Lab9.iservice.IOrderProductService;
import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.OrderProduct;
import com.example._52000691Lab9.model.OrderProductId;
import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Override
    public List<OrderProduct> selectAll() {
        return orderProductRepository.findAll();
    }

    @Override
    public OrderProduct selectById(OrderProductId id) {
        return orderProductRepository.findById(id).orElse(null);
    }

    @Override
    public OrderProduct insert(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public boolean deleteById(OrderProductId id) {
        if (orderProductRepository.existsById(id))
            orderProductRepository.deleteById(id);
        return !orderProductRepository.existsById(id);
    }

    @Override
    public OrderProduct update(OrderProduct orderProductUpdate) {
        return orderProductRepository.save(orderProductUpdate);
    }
}
