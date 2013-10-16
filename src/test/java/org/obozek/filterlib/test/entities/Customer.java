/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.test.entities;

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
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomernumber", query = "SELECT c FROM Customer c WHERE c.customerNumber = :customerNumber"),
    @NamedQuery(name = "Customer.findByCustomername", query = "SELECT c FROM Customer c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Customer.findByContactlastname", query = "SELECT c FROM Customer c WHERE c.contactLastname = :contactLastname"),
    @NamedQuery(name = "Customer.findByContactfirstname", query = "SELECT c FROM Customer c WHERE c.contactFirstname = :contactFirstname"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByAddressline1", query = "SELECT c FROM Customer c WHERE c.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Customer.findByAddressline2", query = "SELECT c FROM Customer c WHERE c.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByState", query = "SELECT c FROM Customer c WHERE c.state = :state"),
    @NamedQuery(name = "Customer.findByPostalcode", query = "SELECT c FROM Customer c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country"),
    @NamedQuery(name = "Customer.findBySalesrepemployeenumber", query = "SELECT c FROM Customer c WHERE c.salesRepEmployeeNumber = :salesRepEmployeeNumber"),
    @NamedQuery(name = "Customer.findByCreditlimit", query = "SELECT c FROM Customer c WHERE c.creditLimit = :creditLimit")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMERNUMBER", nullable = false)
    private Integer customerNumber;
    @Column(name = "CUSTOMERNAME", length = 50)
    private String customerName;
    @Column(name = "CONTACTLASTNAME", length = 50)
    private String contactLastname;
    @Column(name = "CONTACTFIRSTNAME", length = 50)
    private String contactFirstname;
    @Column(name = "PHONE", length = 50)
    private String phone;
    @Column(name = "ADDRESSLINE1", length = 50)
    private String addressLine1;
    @Column(name = "ADDRESSLINE2", length = 50)
    private String addressLine2;
    @Column(name = "CITY", length = 50)
    private String city;
    @Column(name = "STATE", length = 50)
    private String state;
    @Column(name = "POSTALCODE", length = 15)
    private String postalCode;
    @Column(name = "COUNTRY", length = 50)
    private String country;
    @Column(name = "SALESREPEMPLOYEENUMBER")
    private Integer salesRepEmployeeNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CREDITLIMIT", precision = 52)
    private Double creditLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Payment> paymentList;
    @OneToMany(mappedBy = "customernumber")
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(Integer customernumber) {
        this.customerNumber = customernumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastname() {
        return contactLastname;
    }

    public void setContactLastname(String contactLastname) {
        this.contactLastname = contactLastname;
    }

    public String getContactFirstname() {
        return contactFirstname;
    }

    public void setContactFirstname(String contactFirstname) {
        this.contactFirstname = contactFirstname;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Integer salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerNumber != null ? customerNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerNumber == null && other.customerNumber != null) || (this.customerNumber != null && !this.customerNumber.equals(other.customerNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Customers[ customernumber=" + customerNumber + " ]";
    }
}
