package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Repository
public interface ContractDetailsRepository extends JpaRepository<ContractDetails, Long> {

    /**
     * Retrieving the contract details filtered by contractID
     */
    @Query("SELECT c FROM ContractDetails c WHERE c.contractID = :ctrID")
    List<ContractDetails> getCtrDetailsListByCtrID(@Param("ctrID") Integer contractID);

    /**
     * Retrieving the contract details filtered by roomTypeID
     */
    @Query("SELECT c FROM ContractDetails c WHERE c.roomTypeID = :rtID")
    List<ContractDetails> getCtrDetailsByRoomTypeID(@Param("rtID") Integer roomTypeID);

    /**
     * Retrieving the contract details filtered by contractID and roomTypeID
     */
    @Query("SELECT c FROM ContractDetails c WHERE c.roomTypeID = :rtID AND c.contractID = :ctrID")
    ContractDetails getCtrDetailsByRoomTypeIDandCtrID(@Param("rtID") Integer roomTypeID, @Param("ctrID") Integer contractID);
}
