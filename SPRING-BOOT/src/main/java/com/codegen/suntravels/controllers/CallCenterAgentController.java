package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.CallCenterAgent;
import com.codegen.suntravels.services.CallCenterAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "callCenterAgents")
public class CallCenterAgentController {

    @Autowired
    private CallCenterAgentService callCenterAgentService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<CallCenterAgent> getCallCenterAgentList(){
        return callCenterAgentService.getCallCenterAgentList();
    }
}
