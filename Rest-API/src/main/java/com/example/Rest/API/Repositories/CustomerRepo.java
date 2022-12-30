package com.example.Rest.API.Repositories;

import com.example.Rest.API.Components.Customer;
import com.example.Rest.API.DTO.CustomerDTO;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;
public interface CustomerRepo extends CrudRepository<Customer, UUID> {
    Customer save(Customer customer);
    void deleteById(UUID id);
    Customer getCustomerById(UUID id);
}
