package com.codegen.suntravels.entities;

import javax.persistence.*;

/**
 * Created by DELL on 11/18/2017.
 */
@Entity
@Table(name = "SM_COUNTRY", schema = "SYS", catalog = "")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "COUNTRY_ID")
    private Integer countryID;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryID=" + countryID +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!countryID.equals(country.countryID)) return false;
        return countryName.equals(country.countryName);

    }

    @Override
    public int hashCode() {
        int result = countryID.hashCode();
        result = 31 * result + countryName.hashCode();
        return result;
    }
}
