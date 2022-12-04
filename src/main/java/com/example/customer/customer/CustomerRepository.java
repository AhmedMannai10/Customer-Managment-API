package com.example.customer.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(2L, "Hello There"),
                new Customer(1L, "The Weeknd"),
                new Customer(3L, "Testing the dependence injection"),
                new Customer(4L, "Ahmed Mannai")
        );
    }
}
