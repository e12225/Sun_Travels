package com.codegen.suntravels.DAO.entityDAO;

import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 11/15/2017.
 */
@Component
public class ContractDAO {

    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> getContractList(){
        return contractRepository.findAll();
    }

    public Contract getContractByID(Integer contractID){
        return contractRepository.getContractByID(contractID);
    }

    public Contract getContractByHotelID(Integer hotelID){
        return contractRepository.getContractByHotelID(hotelID);
    }

    public void addContract(Contract contract){
        contractRepository.save(contract);
    }
}
