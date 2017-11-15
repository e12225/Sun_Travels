package com.codegen.suntravels.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by DELL on 11/15/2017.
 */
@Embeddable
@Table(name = "SM_CONTRACT_DETAILS", schema = "SYS", catalog = "")
public class ContractDetailsID implements Serializable {

    @Column(name = "CTR_CONTRACT_ID")
    Integer contractID;

    @Column(name = "CTR_RM_TYPE_ID")
    Integer roomTypeID;
}
