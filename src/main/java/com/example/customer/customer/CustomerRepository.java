package com.example.customer.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "The Weeknd", "Messi", "test"),
                new Customer(4L, "Ahmed ", "Mannai", "Mannai")
        );
    }
}
