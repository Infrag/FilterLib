/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CUSTOMERNUMBER"})})
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomernumber", query = "SELECT c FROM Customers c WHERE c.customernumber = :customernumber"),
    @NamedQuery(name = "Customers.findByCustomername", query = "SELECT c FROM Customers c WHERE c.customername = :customername"),
    @NamedQuery(name = "Customers.findByContactlastname", query = "SELECT c FROM Customers c WHERE c.contactlastname = :contactlastname"),
    @NamedQuery(name = "Customers.findByContactfirstname", query = "SELECT c FROM Customers c WHERE c.contactfirstname = :contactfirstname"),
    @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customers.findByAddressline1", query = "SELECT c FROM Customers c WHERE c.addressline1 = :addressline1"),
    @NamedQuery(name = "Customers.findByAddressline2", query = "SELECT c FROM Customers c WHERE c.addressline2 = :addressline2"),
    @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
    @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state"),
    @NamedQuery(name = "Customers.findByPostalcode", query = "SELECT c FROM Customers c WHERE c.postalcode = :postalcode"),
    @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country"),
    @NamedQuery(name = "Customers.findBySalesrepemployeenumber", query = "SELECT c FROM Customers c WHERE c.salesrepemployeenumber = :salesrepemployeenumber"),
    @NamedQuery(name = "Customers.findByCreditlimit", query = "SELECT c FROM Customers c WHERE c.creditlimit = :creditlimit")})
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMERNUMBER", nullable = false)
    private Integer customernumber;
    @Column(name = "CUSTOMERNAME", length = 50)
    private String customername;
    @Column(name = "CONTACTLASTNAME", length = 50)
    private String contactlastname;
    @Column(name = "CONTACTFIRSTNAME", length = 50)
    private String contactfirstname;
    @Column(name = "PHONE", length = 50)
    private String phone;
    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressline1;
    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressline2;
    @Column(name = "CITY", length = 50)
    private String city;
    @Column(name = "STATE", length = 50)
    private String state;
    @Column(name = "POSTALCODE", length = 15)
    private String postalcode;
    @Column(name = "COUNTRY", length = 50)
    private String country;
    @Column(name = "SALESREPEMPLOYEENUMBER")
    private Integer salesrepemployeenumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDITLIMIT", precision = 52)
    private Double creditlimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private List<Payments> paymentsList;
    @OneToMany(mappedBy = "customernumber")
    private List<Orders> ordersList;

    public Customers() {
    }

    public Customers(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public Integer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Integer customernumber) {
        this.customernumber = customernumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getContactlastname() {
        return contactlastname;
    }

    public void setContactlastname(String contactlastname) {
        this.contactlastname = contactlastname;
    }

    public String getContactfirstname() {
        return contactfirstname;
    }

    public void setContactfirstname(String contactfirstname) {
        this.contactfirstname = contactfirstname;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSalesrepemployeenumber() {
        return salesrepemployeenumber;
    }

    public void setSalesrepemployeenumber(Integer salesrepemployeenumber) {
        this.salesrepemployeenumber = salesrepemployeenumber;
    }

    public Double getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(Double creditlimit) {
        this.creditlimit = creditlimit;
    }

    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customernumber != null ? customernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customernumber == null && other.customernumber != null) || (this.customernumber != null && !this.customernumber.equals(other.customernumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Customers[ customernumber=" + customernumber + " ]";
    }
    
}
