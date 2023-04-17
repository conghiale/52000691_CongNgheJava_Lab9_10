package com.example._52000691Lab9.repository;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT op.product FROM OrderProduct op WHERE op.order.id = :orderId")
    List<Product> findProductsByOrderId(@Param("orderId") Integer orderId);

    List<Order> searchByTotalPrice(Double totalPrice);
}
