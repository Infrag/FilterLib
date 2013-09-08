/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.test.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "ORDERDETAILS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ORDERNUMBER", "PRODUCTCODE"})})
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findByOrdernumber", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.ordernumber = :ordernumber"),
    @NamedQuery(name = "Orderdetails.findByProductcode", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.productcode = :productcode"),
    @NamedQuery(name = "Orderdetails.findByQuantityordered", query = "SELECT o FROM Orderdetails o WHERE o.quantityordered = :quantityordered"),
    @NamedQuery(name = "Orderdetails.findByPriceeach", query = "SELECT o FROM Orderdetails o WHERE o.priceeach = :priceeach"),
    @NamedQuery(name = "Orderdetails.findByOrderlinenumber", query = "SELECT o FROM Orderdetails o WHERE o.orderlinenumber = :orderlinenumber")})
public class Orderdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailPK orderdetailsPK;
    @Column(name = "QUANTITYORDERED")
    private Integer quantityordered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICEEACH", precision = 52)
    private Double priceeach;
    @Column(name = "ORDERLINENUMBER")
    private Short orderlinenumber;
    @JoinColumn(name = "PRODUCTCODE", referencedColumnName = "PRODUCTCODE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product products;
    @JoinColumn(name = "ORDERNUMBER", referencedColumnName = "ORDERNUMBER", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order orders;

    public Orderdetail() {
    }

    public Orderdetail(OrderdetailPK orderdetailsPK) {
        this.orderdetailsPK = orderdetailsPK;
    }

    public Orderdetail(int ordernumber, String productcode) {
        this.orderdetailsPK = new OrderdetailPK(ordernumber, productcode);
    }

    public OrderdetailPK getOrderdetailsPK() {
        return orderdetailsPK;
    }

    public void setOrderdetailsPK(OrderdetailPK orderdetailsPK) {
        this.orderdetailsPK = orderdetailsPK;
    }

    public Integer getQuantityordered() {
        return quantityordered;
    }

    public void setQuantityordered(Integer quantityordered) {
        this.quantityordered = quantityordered;
    }

    public Double getPriceeach() {
        return priceeach;
    }

    public void setPriceeach(Double priceeach) {
        this.priceeach = priceeach;
    }

    public Short getOrderlinenumber() {
        return orderlinenumber;
    }

    public void setOrderlinenumber(Short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailsPK != null ? orderdetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderdetailsPK == null && other.orderdetailsPK != null) || (this.orderdetailsPK != null && !this.orderdetailsPK.equals(other.orderdetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Orderdetails[ orderdetailsPK=" + orderdetailsPK + " ]";
    }
    
}
