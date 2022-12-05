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

    void createProduct(Product product){
        productRepository.save(product);
    }

    Product getProductById(Long id){
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            return new IllegalStateException(
                                    "There is no product with that id" +  id);
                        }
                );
    }



}
