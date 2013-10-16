/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.test.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "OFFICES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"OFFICECODE"})})
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o"),
    @NamedQuery(name = "Office.findByOfficecode", query = "SELECT o FROM Office o WHERE o.officeCode = :officeCode"),
    @NamedQuery(name = "Office.findByCity", query = "SELECT o FROM Office o WHERE o.city = :city"),
    @NamedQuery(name = "Office.findByPhone", query = "SELECT o FROM Office o WHERE o.phone = :phone"),
    @NamedQuery(name = "Office.findByAddressline1", query = "SELECT o FROM Office o WHERE o.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Office.findByAddressline2", query = "SELECT o FROM Office o WHERE o.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Office.findByState", query = "SELECT o FROM Office o WHERE o.state = :state"),
    @NamedQuery(name = "Office.findByCountry", query = "SELECT o FROM Office o WHERE o.country = :country"),
    @NamedQuery(name = "Office.findByPostalcode", query = "SELECT o FROM Office o WHERE o.postalCode = :postalCode"),
    @NamedQuery(name = "Office.findByTerritory", query = "SELECT o FROM Office o WHERE o.territory = :territory")})
public class Office implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OFFICECODE", nullable = false, length = 10)
    private String officeCode;
    @Column(name = "CITY", length = 50)
    private String city;
    @Column(name = "PHONE", length = 50)
    private String phone;
    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressLine1;
    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressLine2;
    @Column(name = "STATE", length = 50)
    private String state;
    @Column(name = "COUNTRY", length = 50)
    private String country;
    @Column(name = "POSTALCODE", length = 15)
    private String postalCode;
    @Column(name = "TERRITORY", length = 10)
    private String territory;

    public Office()
    {
    }

    public Office(String officecode)
    {
        this.officeCode = officecode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getOfficeCode()
    {
        return officeCode;
    }

    public void setOfficeCode(String officeCode)
    {
        this.officeCode = officeCode;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getTerritory()
    {
        return territory;
    }

    public void setTerritory(String territory)
    {
        this.territory = territory;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (officeCode != null ? officeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.officeCode == null && other.officeCode != null) || (this.officeCode != null && !this.officeCode.equals(other.officeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.filter.dao.entities.Offices[ officeCode=" + officeCode + " ]";
    }
}
