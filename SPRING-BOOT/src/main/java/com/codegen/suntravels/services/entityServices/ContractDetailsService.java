package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
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

    public List<ContractDetails> getCtrDetailsByCtrID(Integer contractID){
        return this.contractDetailsDAO.getCtrDetailsByCtrID(contractID);
    }

    public ContractDetails getCtrDetailsByCtrIDnRmTypeID(Integer contractID, Integer roomTypeID){
        return this.contractDetailsDAO.getCtrDetailsByCtrIDnRmTypeID(contractID, roomTypeID);
    }

    public void addContractDetails(ContractDetails contractDetails){
        this.contractDetailsDAO.addContractDetails(contractDetails);
    }
}
