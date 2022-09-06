package com.bootcamp.mongodb.mongodb.Model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {

    public Customer findByFirstName(String firstName);
    public Customer findByLastName(String lastName);

}
