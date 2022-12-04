package com.example.customer.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Customer {

    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Id
    @NotNull
    private Long id;

    @NotBlank(message = "name must be not empty")
    private String name ;

    @NotBlank(message = "username must be not empty")
    private String username;
    @NotBlank
    @Email
    private String email;

    // The ignore property above getPassword prevent us from posting the password
    // we should use JsonProperty for allowing WRITE_ONLY
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;

    public Customer(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    @JsonProperty("customer_name")
    public String getName() {
        return name;
    }
    // by default, it converts the name of the method from getName -> name

    public String getUsername() {
        return username;
    }

    public String getEmail(){
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
