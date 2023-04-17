package com.example._52000691Lab9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    private String name;
    private Double price;
    private String image;
    private String description;
}
