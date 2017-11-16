package com.codegen.suntravels.controllers;

import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.services.ContractDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@RestController
@RequestMapping("contractDetails")
public class ContractDetailsController {

    @Autowired
    private ContractDetailsService contractDetailsService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<ContractDetails> getContractDetailsList(){
        return contractDetailsService.getContractDetailsList();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addContractDetails(@RequestBody ContractDetails contractDetails){
        contractDetailsService.addContractDetails(contractDetails);
    }
}
