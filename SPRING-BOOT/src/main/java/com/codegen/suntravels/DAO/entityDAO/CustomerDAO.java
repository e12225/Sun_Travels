package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.Customer;
import com.codegen.suntravels.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomerList(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
