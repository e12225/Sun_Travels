package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //TODO : implement 'searchCustomerByName()' here
}
