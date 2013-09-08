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
    @NamedQuery(name = "Offices.findAll", query = "SELECT o FROM Offices o"),
    @NamedQuery(name = "Offices.findByOfficecode", query = "SELECT o FROM Offices o WHERE o.officecode = :officecode"),
    @NamedQuery(name = "Offices.findByCity", query = "SELECT o FROM Offices o WHERE o.city = :city"),
    @NamedQuery(name = "Offices.findByPhone", query = "SELECT o FROM Offices o WHERE o.phone = :phone"),
    @NamedQuery(name = "Offices.findByAddressline1", query = "SELECT o FROM Offices o WHERE o.addressline1 = :addressline1"),
    @NamedQuery(name = "Offices.findByAddressline2", query = "SELECT o FROM Offices o WHERE o.addressline2 = :addressline2"),
    @NamedQuery(name = "Offices.findByState", query = "SELECT o FROM Offices o WHERE o.state = :state"),
    @NamedQuery(name = "Offices.findByCountry", query = "SELECT o FROM Offices o WHERE o.country = :country"),
    @NamedQuery(name = "Offices.findByPostalcode", query = "SELECT o FROM Offices o WHERE o.postalcode = :postalcode"),
    @NamedQuery(name = "Offices.findByTerritory", query = "SELECT o FROM Offices o WHERE o.territory = :territory")})
public class Office implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OFFICECODE", nullable = false, length = 10)
    private String officecode;
    @Column(name = "CITY", length = 50)
    private String city;
    @Column(name = "PHONE", length = 50)
    private String phone;
    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressline1;
    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressline2;
    @Column(name = "STATE", length = 50)
    private String state;
    @Column(name = "COUNTRY", length = 50)
    private String country;
    @Column(name = "POSTALCODE", length = 15)
    private String postalcode;
    @Column(name = "TERRITORY", length = 10)
    private String territory;

    public Office() {
    }

    public Office(String officecode) {
        this.officecode = officecode;
    }

    public String getOfficecode() {
        return officecode;
    }

    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (officecode != null ? officecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.officecode == null && other.officecode != null) || (this.officecode != null && !this.officecode.equals(other.officecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Offices[ officecode=" + officecode + " ]";
    }
    
}
