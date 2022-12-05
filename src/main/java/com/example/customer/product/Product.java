package com.example.customer.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


import javax.persistence.*;
@Table
@Entity
public class Product {

    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @NotNull
    @Id
    private Long productId;
    private String productName;
    private LocalDate dateCreated;
    private Integer quantity = 0;

    public Product(String productName, LocalDate dateCreated, Integer quantity) {
        this.productName = productName;
        this.dateCreated = dateCreated;
        this.quantity = quantity > 0 ? quantity : 0;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", dateCreated=" + dateCreated +
                ", quantity=" + quantity +
                '}';
    }
}
