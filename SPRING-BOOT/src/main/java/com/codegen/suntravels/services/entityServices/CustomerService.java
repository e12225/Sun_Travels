package com.codegen.suntravels.services.entityServices;

import com.codegen.suntravels.DAO.entityDAO.CityDAO;
import com.codegen.suntravels.DAO.entityDAO.CountryDAO;
import com.codegen.suntravels.DAO.entityDAO.CustomerDAO;
import com.codegen.suntravels.entities.City;
import com.codegen.suntravels.entities.Country;
import com.codegen.suntravels.entities.Customer;
import com.codegen.suntravels.entityRequests.AddCustomerRequest;
import com.codegen.suntravels.entityResponses.AddEntityResponse;
import com.codegen.suntravels.entityResponses.CustomerListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private CityDAO cityDAO;

    public List<CustomerListResponse> getCustomerList()
    {

        List<CustomerListResponse> response = new ArrayList<>();

        List<Customer> list = customerDAO.getCustomerList();

        for( Customer customer : list )
        {
            CustomerListResponse r = new CustomerListResponse();

            r.setCustomerID( customer.getCustomerID() );
            r.setCustomerFirstName( customer.getCustomerFirstName() );
            r.setCustomerLastName( customer.getCustomerLastName() );
            r.setCustomerPhoneNumber( customer.getCustomerPhoneNumber() );
            r.setCountryName( countryDAO.getCountryByID( customer.getCountryID() ).getCountryName() );
            r.setCityName( cityDAO.getCityByID( customer.getCityID() ).getCityName() );
            r.setSsnOrNic( customer.getSsnOrNic() );
            response.add( r );
        }

        return response;
    }

    public List<CustomerListResponse> getCustomerByNameOrAlias( String name )
    {

        List<CustomerListResponse> response = new ArrayList<>();

        List<Customer> list = customerDAO.getCustomerByNameOrAlias( name );

        for( Customer customer : list )
        {
            CustomerListResponse r = new CustomerListResponse();

            r.setCustomerID( customer.getCustomerID() );
            r.setCustomerFirstName( customer.getCustomerFirstName() );
            r.setCustomerLastName( customer.getCustomerLastName() );
            r.setCustomerPhoneNumber( customer.getCustomerPhoneNumber() );
            r.setCountryName( countryDAO.getCountryByID( customer.getCountryID() ).getCountryName() );
            r.setCityName( cityDAO.getCityByID( customer.getCityID() ).getCityName() );
            r.setSsnOrNic( customer.getSsnOrNic() );
            response.add( r );
        }

        return response;
    }

    public CustomerListResponse getCustomerByIdentity( String identity )
    {

        CustomerListResponse response = new CustomerListResponse();

        Customer customer = customerDAO.getCustomerByIdentity( identity );

        response.setCustomerID( customer.getCustomerID() );
        response.setCustomerFirstName( customer.getCustomerFirstName() );
        response.setCustomerLastName( customer.getCustomerLastName() );
        response.setCustomerPhoneNumber( customer.getCustomerPhoneNumber() );
        response.setCountryName( countryDAO.getCountryByID( customer.getCountryID() ).getCountryName() );
        response.setCityName( cityDAO.getCityByID( customer.getCityID() ).getCityName() );
        response.setSsnOrNic( customer.getSsnOrNic() );

        return response;
    }

    public AddEntityResponse addCustomer( AddCustomerRequest request )
    {

        AddEntityResponse response = new AddEntityResponse();

        Country co = countryDAO.getCountryByName( request.getCountryName() );

        if( co != null )
        {

            City ci = cityDAO.getCityBelongstoGivenCountry( co.getCountryID(), request.getCityName() );

            if( ci == null )
            {
                response.setInsertingStatus( false );
                response.setEntity( null );
                response.setMessage( "A city named " + request.getCityName() + " under the given country named " + request.getCountryName() + " doesn't exists in the system" );
            }
            else
            {
                Customer cu = customerDAO.getCustomerByIdentity( request.getSsnOrNic() );

                if( cu != null )
                {
                    response.setInsertingStatus( false );
                    response.setEntity( null );
                    response.setMessage( "A customer with SSN or NIC : " + request.getSsnOrNic() + "  already exists in the system" );
                }
                else
                {
                    Customer customer = new Customer();
                    customer.setCustomerFirstName( request.getCustomerFirstName() );
                    customer.setCustomerLastName( request.getCustomerLastName() );
                    customer.setCustomerPhoneNumber( request.getCustomerPhoneNumber() );
                    customer.setCountryID( co.getCountryID() );
                    customer.setCityID( ci.getCityID() );
                    customer.setSsnOrNic( request.getSsnOrNic() );

                    customerDAO.addCustomer( customer );

                    response.setInsertingStatus( true );
                    response.setEntity( customer );
                    response.setMessage( "A new customer successfully added to the system" );
                }
            }
        }
        else
        {
            response.setInsertingStatus( false );
            response.setEntity( null );
            response.setMessage( "A country named " + request.getCountryName() + " doesn't exist in the system" );
        }

        return response;
    }
}
