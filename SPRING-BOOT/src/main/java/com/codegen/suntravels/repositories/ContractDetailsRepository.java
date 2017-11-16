package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by DELL on 11/15/2017.
 */
@Repository
public interface ContractDetailsRepository extends JpaRepository<ContractDetails, Long> {

    // TODO : implement 'findBy...()'
}
