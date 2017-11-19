package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.services.entityServices.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@RestController
@RequestMapping("contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Contract> getContractList(){
        return contractService.getContractList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{contractID}")
    public Contract getContractByID(@PathParam("contractID") Integer contractID){
        return contractService.getContractByID(contractID);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addContract(@RequestBody Contract contract){
        contractService.addContract(contract);
    }

}
