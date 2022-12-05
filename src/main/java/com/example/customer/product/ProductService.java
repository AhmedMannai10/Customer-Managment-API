package com.example.customer.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
       this.productRepository = productRepository;
    }

    List<Product> getProducts(){
        return productRepository.findAll();
    }
}
