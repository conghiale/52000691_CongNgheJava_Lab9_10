package com.example._52000691Lab9.repository;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.OrderProduct;
import com.example._52000691Lab9.model.OrderProductId;
import com.example._52000691Lab9.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}
