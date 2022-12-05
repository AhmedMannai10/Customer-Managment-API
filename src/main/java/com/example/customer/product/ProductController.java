package com.example.customer.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    void createProduct(@RequestBody Product product){
         productService.createProduct(product);
    }

    @GetMapping(path = "{id}")
    Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


}
