package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entityRequests.AddContractRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.ContractListResponse;
import com.codegen.suntravels.services.entityServices.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ContractListResponse> getContractList(){
        return contractService.getContractList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{contractID}")
    public ContractListResponse getContractByID(@PathVariable("contractID") Integer contractID){
        return contractService.getContractByID(contractID);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByHotelID/{hotelID}")
    public List<ContractListResponse> getContractByHotelID(@PathVariable("hotelID") Integer hotelID){
        return contractService.getContractByHotelID(hotelID);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByHotelName/{hotelName}")
    public List<ContractListResponse> getContractsByHotelName( @PathVariable("hotelName") String hotelName){
        return contractService.getContractByHotelName(hotelName);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addContract( @RequestBody AddContractRequest request){
        return contractService.addContract(request);
    }
}
