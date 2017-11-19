package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Service
public class ContractService {

    @Autowired
    private ContractDAO contractDAO;

    public List<Contract> getContractList(){
        return this.contractDAO.getContractList();
    }

    public Contract getContractByID(Integer contractID){
        return this.contractDAO.getContractByID(contractID);
    }

    public void addContract(Contract contract){
        this.contractDAO.addContract(contract);
    }

}
