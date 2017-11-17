package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.Customer;
import com.codegen.suntravels.services.entityServices.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Customer> getCustomerList(){
        return customerService.getCustomerList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

}
