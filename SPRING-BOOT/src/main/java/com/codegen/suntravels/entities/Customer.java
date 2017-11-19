package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_CUSTOMER", schema = "SYS", catalog = "")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUST_ID")
    private Integer customerID;

    @Column(name = "CUST_NAME")
    private String customerName;

    @Column(name = "CUST_PHONE_NO")
    private Integer customerPhoneNumber;

    @Column(name = "CUST_COUNTRY_ID")
    private Integer countryID;

    @Column(name = "CUST_CITY_ID")
    private Integer cityID;

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(Integer customerPhoneNumber) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber=" + customerPhoneNumber +
                ", countryID=" + countryID +
                ", cityID=" + cityID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!customerID.equals(customer.customerID)) return false;
        if (!customerName.equals(customer.customerName)) return false;
        if (!customerPhoneNumber.equals(customer.customerPhoneNumber)) return false;
        if (!countryID.equals(customer.countryID)) return false;
        return cityID.equals(customer.cityID);

    }

    @Override
    public int hashCode() {
        int result = customerID.hashCode();
        result = 31 * result + customerName.hashCode();
        result = 31 * result + customerPhoneNumber.hashCode();
        result = 31 * result + countryID.hashCode();
        result = 31 * result + cityID.hashCode();
        return result;
    }
}
