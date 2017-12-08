package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Retrieving the customers filtered by customerName
     */
    @Query("SELECT c FROM Customer c WHERE upper(c.customerName) LIKE CONCAT('%',upper(:cName),'%') OR lower(c.customerName) LIKE CONCAT('%',lower(:cName),'%')")
    Customer getCustomerByName(@Param("cName") String customerName);
}
