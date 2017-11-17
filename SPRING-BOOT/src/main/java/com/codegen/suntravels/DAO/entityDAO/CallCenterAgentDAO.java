package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.CallCenterAgent;
import com.codegen.suntravels.repositories.CallCenterAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CallCenterAgentDAO {

    @Autowired
    private CallCenterAgentRepository callCenterAgentRepository;

    public List<CallCenterAgent> getCallCenterAgentList(){
        return callCenterAgentRepository.findAll();
    }
}
