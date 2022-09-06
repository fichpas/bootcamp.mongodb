package com.bootcamp.mongodb.mongodb;

import com.bootcamp.mongodb.mongodb.Model.Customer;
import com.bootcamp.mongodb.mongodb.Model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/save")
    public Greeting save(@RequestParam(value = "firstname") String firstname,@RequestParam(value = "lastname")String lastname) {

        repository.save(new Customer(firstname,lastname));

        Customer customer = repository.findByFirstName(firstname);

        return new Greeting(customer.getId(), String.format(template, firstname));
    }

    @GetMapping("/find")
    public Greeting find(@RequestParam(value = "lastname") String lastname) {
        Customer customer = repository.findByLastName(lastname);
        return new Greeting(customer.getId(), String.format(template, customer.getFirstName()));
    }

}
