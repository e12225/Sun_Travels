package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>
{

    /**
     * Retrieving the contracts filtered by contractID
     */
    @Query("SELECT ctr FROM Contract ctr WHERE ctr.contractID = :ctrID")
    Contract getContractByID( @Param("ctrID") Integer contractID );

    /**
     * Retrieving the contracts filtered by hotelID
     */
    @Query("SELECT ctr FROM Contract ctr WHERE ctr.hotelID = :hID")
    List<Contract> getContractByHotelID( @Param("hID") Integer hotelID );

}
