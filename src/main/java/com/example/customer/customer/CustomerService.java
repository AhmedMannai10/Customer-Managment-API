package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private ICustomerRepo customerRepo;

    @Autowired
    public CustomerService( ICustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

}
