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

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber=" + customerPhoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!customerID.equals(customer.customerID)) return false;
        if (!customerName.equals(customer.customerName)) return false;
        return customerPhoneNumber.equals(customer.customerPhoneNumber);
    }

    @Override
    public int hashCode() {
        int result = customerID.hashCode();
        result = 31 * result + customerName.hashCode();
        result = 31 * result + customerPhoneNumber.hashCode();
        return result;
    }
}
