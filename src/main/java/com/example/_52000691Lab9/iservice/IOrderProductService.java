package com.example._52000691Lab9.iservice;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.OrderProduct;
import com.example._52000691Lab9.model.OrderProductId;
import com.example._52000691Lab9.model.Product;

import java.util.List;

public interface IOrderProductService {
    List<OrderProduct> selectAll();
    OrderProduct selectById(OrderProductId id);
    OrderProduct insert(OrderProduct orderProduct);
    boolean deleteById(OrderProductId id);
    OrderProduct update(OrderProduct orderProductUpdate);
}
