package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entityRequests.AddContractDetailsRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.ContractDetailsListByHtNameResponse;
import com.codegen.suntravels.entityResponses.ContractDetailsListResponse;
import com.codegen.suntravels.services.entityServices.ContractDetailsService;
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
@RequestMapping("contractDetails")
public class ContractDetailsController
{

    @Autowired
    private ContractDetailsService contractDetailsService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<ContractDetailsListResponse> getContractDetailsList()
    {
        return contractDetailsService.getContractDetailsList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list/{contractID}")
    public List<ContractDetailsListResponse> getCtrDetailsByCtrID( @PathVariable("contractID") Integer contractID )
    {
        return contractDetailsService.getCtrDetailsByCtrID( contractID );
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByRoomType/{roomType}")
    public List<ContractDetailsListResponse> getContractDetailsByRoomType( @PathVariable("roomType") String roomType )
    {
        return contractDetailsService.getContractDetailsByRoomTypeNameOrAlias( roomType );
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByHotelName/{hotelName}")
    public List<ContractDetailsListByHtNameResponse> getContractDetailsByHotelName( @PathVariable("hotelName") String hotelName){
        return contractDetailsService.getContractDetailsByHotelName( hotelName );
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addContractDetails( @RequestBody AddContractDetailsRequest request )
    {
        return contractDetailsService.addContractDetails( request );
    }
}
