package com.example.customer.customer;

import com.example.customer.product.Product;
import com.example.customer.product.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository, ProductRepository productRepository){
        return args -> {
            System.out.println("Command Line runner");
            Customer Mannai = new Customer( "Mannai", "mannai", "Mannai@gmail.com", "test");
            Customer  Messi = new Customer( "Messi", "mannai", "messi@gmail.com", "test");
            Customer Ghost = new Customer( "Ghost", "mannai", "ghost@gmail.com", "test");
            Product p1 = new Product("MacBook", LocalDate.now(),23 );
            Product p2 = new Product("Asus", LocalDate.now(),100 );
            Product p3 = new Product("Dell xp13", LocalDate.now(),20 );
            repository.saveAll(
                List.of(Mannai, Messi, Ghost)
            );
            productRepository.saveAll(List.of(p1, p2, p3));
        };
    }

    @Bean
    ICustomerRepo customerRepo() {
        System.out.println("useFakeRepository : " + useFakeCustomerRepo);
        return new CustomerFakeRepo();
    }
}
