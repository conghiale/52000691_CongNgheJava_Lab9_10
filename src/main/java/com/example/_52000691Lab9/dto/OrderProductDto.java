package com.example._52000691Lab9.dto;

import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderProductDto {
    private Product product;
    private Order order;
}
