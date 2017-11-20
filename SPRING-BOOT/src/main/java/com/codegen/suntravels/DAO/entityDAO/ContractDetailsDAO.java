package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.repositories.ContractDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Component
public class ContractDetailsDAO {

    @Autowired
    private ContractDetailsRepository contractDetailsRepository;

    public List<ContractDetails> getContractDetailsList(){
        return contractDetailsRepository.findAll();
    }

    public List<ContractDetails> getCtrDetailsByCtrID(Integer contractID){
        return contractDetailsRepository.getCtrDetailsList(contractID);
    }

    public ContractDetails getCtrDetailsByCtrIDnRmTypeID(Integer contractID, Integer roomTypeID){
        return contractDetailsRepository.getCtrDetailsByCtrIDnRmTypeID(contractID, roomTypeID);
    }

    public void addContractDetails(ContractDetails contractDetails){
        contractDetailsRepository.save(contractDetails);
    }

    public void updateContractDetails(ContractDetails contractDetails){

    }
}
