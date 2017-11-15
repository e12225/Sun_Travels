package com.codegen.suntravels.services;

import com.codegen.suntravels.DAO.ContractDetailsDAO;
import com.codegen.suntravels.entities.ContractDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Service
public class ContractDetailsService {

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    public List<ContractDetails> getContractDetailsList(){
        return this.contractDetailsDAO.getContractDetailsList();
    }

    public void addContractDetails(ContractDetails contractDetails){
        this.contractDetailsDAO.addContractDetails(contractDetails);
    }
}