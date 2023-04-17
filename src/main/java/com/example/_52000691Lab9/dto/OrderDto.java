package com.example._52000691Lab9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {
    private String status;
    private Set<OrderProductDto> orderProducts;
    private Double price;
}
