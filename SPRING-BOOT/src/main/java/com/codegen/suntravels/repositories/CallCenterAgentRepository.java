package com.codegen.suntravels.repositories;

import com.codegen.suntravels.entities.CallCenterAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallCenterAgentRepository extends JpaRepository<CallCenterAgent, Long> {

    //TODO : implement 'searchCCAgentByName()' here
}
