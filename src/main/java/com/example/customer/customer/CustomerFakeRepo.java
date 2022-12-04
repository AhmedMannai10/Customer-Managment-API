package com.example.customer.customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepo implements ICustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
         new Customer(23L, "Ahmed Mannai")
        );
    }
}
