package com.codegen.suntravels.controllers.entityControllers;

import com.codegen.suntravels.entityRequests.AddCustomerRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.CustomerListResponse;
import com.codegen.suntravels.services.entityServices.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<CustomerListResponse> getCustomerList(){
        return customerService.getCustomerList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByName/{customerName}")
    public List<CustomerListResponse> getCustomerByNameOrAlias(@PathVariable("customerName") String customerName){
        return customerService.getCustomerByNameOrAlias(customerName);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listByIdentity/{identity}")
    public CustomerListResponse getCustomerByIdentity(@PathVariable("identity") String identity){
        return customerService.getCustomerByIdentity(identity);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AddEntityResponse addCustomer(@RequestBody AddCustomerRequest request){
        return customerService.addCustomer(request);
    }

}
