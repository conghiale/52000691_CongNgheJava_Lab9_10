package com.example._52000691Lab9.service;

import com.example._52000691Lab9.iservice.IProductService;
import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> selectAll() {
        return productRepository.findAll();
    }

    @Override
    public Product selectById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product insert(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (productRepository.existsById(id))
            productRepository.deleteById(id);
        return !productRepository.existsById(id);
    }

    @Override
    public Product update(Product productUpdate) {
        return productRepository.save(productUpdate);
    }

    @Override
    public List<Product> searchByPrice(Double price) {
        return productRepository.searchByPrice(price);
    }
}
