package com.example._52000691Lab9.repository;

import com.example._52000691Lab9.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> searchByPrice(Double price);
}
