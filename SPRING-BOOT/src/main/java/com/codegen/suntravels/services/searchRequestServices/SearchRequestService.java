package com.codegen.suntravels.services.searchRequestServices;

import com.codegen.suntravels.DAO.entityDAO.ContractDAO;
import com.codegen.suntravels.DAO.entityDAO.ContractDetailsDAO;
import com.codegen.suntravels.DAO.requestDAO.SearchRequestDAO;
import com.codegen.suntravels.entities.Contract;
import com.codegen.suntravels.entities.ContractDetails;
import com.codegen.suntravels.searchResponses.AvailableReservationComposer;
import com.codegen.suntravels.searchRequests.SearchReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/16/2017.
 */
@Service
public class SearchRequestService
{

    @Autowired
    private SearchRequestDAO searchRequestDAO;

    @Autowired
    private ContractDAO contractsDAO;

    @Autowired
    private ContractDetailsDAO contractDetailsDAO;

    public List<AvailableReservationComposer> processSearchRequest( SearchReservationRequest request )
    {
        List<Contract> contracts = contractsDAO.getContractList();

        List<AvailableReservationComposer> availableReservations = new ArrayList<>();

        for( Contract contract : contracts )
        {
            List<ContractDetails> contractDetailsList = contractDetailsDAO.getCtrDetailsByCtrID( contract.getContractID() );

            if( contractDetailsList.size() != 0 )
            {

                List<ContractDetails> validContractDetailsList = searchRequestDAO.getValidContractDetailsList( contractDetailsList, request );

                if( validContractDetailsList != null )
                {
                    /**
                     * i.e the contract and its contract details list(by default) are valid
                     */
                    availableReservations.addAll( searchRequestDAO.getRoomTypesWithEnoughRooms( validContractDetailsList, request, contract ) );
                }
            }
        }

        return availableReservations;
    }
}
