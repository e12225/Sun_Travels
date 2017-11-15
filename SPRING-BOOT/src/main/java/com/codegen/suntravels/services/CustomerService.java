package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.CustomerDAO;
import com.codegen.suntravels.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getCustomerList(){
        return this.customerDAO.getCustomerList();
    }

    public void addCustomer(Customer customer){
        this.customerDAO.addCustomer(customer);
    }
}
