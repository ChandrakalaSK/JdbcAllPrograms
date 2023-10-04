package com.ineuron.CustomerManagement.service;

import com.ineuron.CustomerManagement.dao.CustomerRepository;
import com.ineuron.CustomerManagement.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService ")
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public void test()
    {
        Customer customer = new Customer(1,"chandrakala","kundagol");
        repository.save(customer);
    }
}
