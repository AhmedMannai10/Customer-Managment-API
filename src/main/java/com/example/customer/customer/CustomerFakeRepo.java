package com.example.customer.customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepo implements ICustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
         new Customer( "Ahmed Mannai", "GhostAr", "email@gmail.com", "ghost101")
        );
    }
}
