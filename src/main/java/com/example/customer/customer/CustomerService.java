package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService( CustomerRepository customerRepository){
        this.customerRepository = customerRepository ;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    void createCustomer(Customer customer){
        System.out.println("Adding Customer");
        System.out.println(customer);
        customerRepository.save(customer);
    }

    void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    Customer getCustomer(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException(
                                "Customer with id = "  + id + "not found"
                        )
                );
    }



}
