package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Retrieving the customers filtered by customerName
     */
    @Query("SELECT c FROM Customer c WHERE c.customerName = :cName")
    Customer getCustomerByName(@Param("cName") String customerName);
}
