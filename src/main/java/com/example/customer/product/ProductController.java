package com.example.customer.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/products")
@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){
       this.productService = productService;
    }

    @GetMapping
    List<Product> getProducts(){
        return productService.getProducts();
    }


}
