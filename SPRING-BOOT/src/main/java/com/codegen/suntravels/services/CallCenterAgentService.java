package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.CallCenterAgentDAO;
import com.codegen.suntravels.entities.CallCenterAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallCenterAgentService {

    @Autowired
    private CallCenterAgentDAO callCenterAgentDAO;

    public List<CallCenterAgent> getCallCenterAgentList(){
        return this.callCenterAgentDAO.getCallCenterAgentList();
    }
}
