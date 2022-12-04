package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            System.out.println("Command Line runner");
            Customer Mannai = new Customer( "Mannai", "mannai", "Mannai@gmail.com", "test");
            Customer  Messi = new Customer( "Messi", "mannai", "messi@gmail.com", "test");
            Customer Ghost = new Customer( "Ghost", "mannai", "ghost@gmail.com", "test");
            repository.saveAll(
                List.of(Mannai, Messi, Ghost)
            );
        };
    }

    @Bean
    ICustomerRepo customerRepo() {
        System.out.println("useFakeRepository : " + useFakeCustomerRepo);
        return new CustomerFakeRepo();
    }
}
