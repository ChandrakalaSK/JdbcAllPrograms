package com.ineuron.CustomerManagement;

import com.ineuron.CustomerManagement.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ineuron.CustomerManagement");
        applicationContext.refresh();

        CustomerService customerService= (CustomerService) applicationContext.getBean("customerService");
        customerService.test();

        applicationContext.close();
    }
}
