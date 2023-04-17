package com.example._52000691Lab9.controller;

import com.example._52000691Lab9.dto.OrderDto;
import com.example._52000691Lab9.dto.OrderProductDto;
import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.OrderProduct;
import com.example._52000691Lab9.model.OrderStatus;
import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.repository.OrderProductRepository;
import com.example._52000691Lab9.service.OrderService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderProductRepository orderProductRepository;

    @RolesAllowed("CUSTOMER")
    @GetMapping
    public ResponseEntity<List<Order>> viewOrders() {
        List<Order> orders = orderService.selectAll();
        return ResponseEntity.ofNullable(orders);
    }

    @RolesAllowed("CUSTOMER")
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Product>> viewOrderById(@PathVariable("id") Integer id) {
        List<Product> productByIdOrder = orderService.findProductsByOrderId(id);
        return ResponseEntity.ofNullable(productByIdOrder);
    }

    @RolesAllowed("CUSTOMER")
    @PostMapping(value = "/search/{price}")
    public ResponseEntity<List<Order>> searchOrdersByPrice(@PathVariable("price") Double price) {
        List<Order> products = orderService.searchByTotalPrice(price);
        return ResponseEntity.ofNullable(products);
    }

    @RolesAllowed("ADMIN")
    @PostMapping
    public ResponseEntity<Order> insertOrder(@RequestBody OrderDto orderDto) {
        Set<OrderProduct> orderProducts = new HashSet<>();

        for (OrderProductDto orderProductDto : orderDto.getOrderProducts()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(orderProductDto.getOrder());
            orderProduct.setProduct(orderProductDto.getProduct());

            orderProducts.add(orderProduct);
        }

        Order order = new Order();
        order.setStatus(orderDto.getStatus());
        order.setTotalPrice(orderDto.getPrice());
        order.setOrderProducts(orderProducts);

        Order order1 = orderService.insert(order);
        return ResponseEntity.ofNullable(order1);
    }
}
