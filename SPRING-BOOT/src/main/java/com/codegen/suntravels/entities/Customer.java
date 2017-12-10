package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_CUSTOMER", schema = "SYS", catalog = "")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUST_ID")
    private Integer customerID;

    @Column(name = "CUST_FIRST_NAME")
    private String customerFirstName;

    @Column(name = "CUST_LAST_NAME")
    private String customerLastName;

    @Column(name = "CUST_PHONE_NO")
    private Long customerPhoneNumber;

    @Column(name = "CUST_COUNTRY_ID")
    private Integer countryID;

    @Column(name = "CUST_CITY_ID")
    private Integer cityID;

    @Column(name = "CUST_SSN_OR_NIC")
    private String ssnOrNic;

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Long getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(Long customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getSsnOrNic() {
        return ssnOrNic;
    }

    public void setSsnOrNic(String ssnOrNic) {
        this.ssnOrNic = ssnOrNic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!customerID.equals(customer.customerID)) return false;
        if (!customerFirstName.equals(customer.customerFirstName)) return false;
        if (!customerLastName.equals(customer.customerLastName)) return false;
        if (!customerPhoneNumber.equals(customer.customerPhoneNumber)) return false;
        if (!countryID.equals(customer.countryID)) return false;
        if (!cityID.equals(customer.cityID)) return false;
        return ssnOrNic.equals(customer.ssnOrNic);

    }

    @Override
    public int hashCode() {
        int result = customerID.hashCode();
        result = 31 * result + customerFirstName.hashCode();
        result = 31 * result + customerLastName.hashCode();
        result = 31 * result + customerPhoneNumber.hashCode();
        result = 31 * result + countryID.hashCode();
        result = 31 * result + cityID.hashCode();
        result = 31 * result + ssnOrNic.hashCode();
        return result;
    }
}
