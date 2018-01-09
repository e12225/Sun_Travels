package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{

    /**
     * Retrieving the customers filtered by customerName or alias
     */
    @Query("SELECT c FROM Customer c WHERE upper(c.customerFirstName) LIKE CONCAT('%',upper(:cName),'%') OR lower(c.customerFirstName) LIKE CONCAT('%',lower(:cName),'%')" +
            "OR upper(c.customerLastName) LIKE CONCAT('%',upper(:cName),'%') OR lower(c.customerLastName) LIKE CONCAT('%',lower(:cName),'%')")
    List<Customer> getCustomerByNameOrAlias( @Param("cName") String customerName );

    /**
     * Retrieving the customer filtered by customer nic or ssn
     */
    @Query("SELECT c FROM Customer c WHERE c.ssnOrNic = :cIdentity")
    Customer getCustomerByIdentity( @Param("cIdentity") String ssnOrNic );
}
