package com.example._52000691Lab9.controller;

import com.example._52000691Lab9.dto.OrderDto;
import com.example._52000691Lab9.dto.OrderProductDto;
import com.example._52000691Lab9.dto.ProductDto;
import com.example._52000691Lab9.model.Order;
import com.example._52000691Lab9.model.OrderProduct;
import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.model.Roles;
import com.example._52000691Lab9.repository.OrderProductRepository;
import com.example._52000691Lab9.service.OrderService;
import com.example._52000691Lab9.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
    private final ProductService productService;
    @RolesAllowed("CUSTOMER")
    @GetMapping
    public ResponseEntity<List<Product>> viewProducts() {
        List<Product> products = productService.selectAll();
        return ResponseEntity.ofNullable(products);
    }

    @RolesAllowed("CUSTOMER")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> viewProductById(@PathVariable("id") Integer id) {
        Product product = productService.selectById(id);
        return ResponseEntity.ofNullable(product);
    }

    @RolesAllowed("CUSTOMER")
    @PostMapping(value = "/search/{price}")
    public ResponseEntity<List<Product>> searchProductsByPrice(@PathVariable("price") Double price) {
        List<Product> products = productService.searchByPrice(price);
        return ResponseEntity.ofNullable(products);
    }

    @RolesAllowed("ADMIN")
    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());

        Product product1 = productService.insert(product);
        return ResponseEntity.ofNullable(product1);
    }
}
