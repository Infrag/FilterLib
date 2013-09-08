/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.test.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "ORDERS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ORDERNUMBER"})})
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrdernumber", query = "SELECT o FROM Orders o WHERE o.ordernumber = :ordernumber"),
    @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Orders.findByRequireddate", query = "SELECT o FROM Orders o WHERE o.requireddate = :requireddate"),
    @NamedQuery(name = "Orders.findByShippeddate", query = "SELECT o FROM Orders o WHERE o.shippeddate = :shippeddate"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")})
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERNUMBER", nullable = false)
    private Integer ordernumber;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "REQUIREDDATE")
    @Temporal(TemporalType.DATE)
    private Date requireddate;
    @Column(name = "SHIPPEDDATE")
    @Temporal(TemporalType.DATE)
    private Date shippeddate;
    @Column(name = "STATUS", length = 15)
    private String status;
    @Lob
    @Column(name = "COMMENTS", length = 32700)
    private String comments;
    @JoinColumn(name = "CUSTOMERNUMBER", referencedColumnName = "CUSTOMERNUMBER")
    @ManyToOne
    private Customer customernumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private List<Orderdetail> orderdetailsList;

    public Order() {
    }

    public Order(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(Customer customernumber) {
        this.customernumber = customernumber;
    }

    public List<Orderdetail> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetail> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordernumber != null ? ordernumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.ordernumber == null && other.ordernumber != null) || (this.ordernumber != null && !this.ordernumber.equals(other.ordernumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Orders[ ordernumber=" + ordernumber + " ]";
    }
    
}
