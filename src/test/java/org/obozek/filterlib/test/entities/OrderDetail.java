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
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByOrdernumber", query = "SELECT o FROM OrderDetail o WHERE o.orderdetailsPK.ordernumber = :ordernumber"),
    @NamedQuery(name = "OrderDetail.findByProductcode", query = "SELECT o FROM OrderDetail o WHERE o.orderdetailsPK.productcode = :productcode"),
    @NamedQuery(name = "OrderDetail.findByQuantityordered", query = "SELECT o FROM OrderDetail o WHERE o.quantityordered = :quantityordered"),
    @NamedQuery(name = "OrderDetail.findByPriceeach", query = "SELECT o FROM OrderDetail o WHERE o.priceeach = :priceeach"),
    @NamedQuery(name = "OrderDetail.findByOrderlinenumber", query = "SELECT o FROM OrderDetail o WHERE o.orderlinenumber = :orderlinenumber")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderDetailPK orderDetailsPK;
    @Column(name = "QUANTITYORDERED")
    private Integer quantityOrdered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICEEACH", precision = 52)
    private Double priceEach;
    @Column(name = "ORDERLINENUMBER")
    private Short orderlinenumber;
    @JoinColumn(name = "PRODUCTCODE", referencedColumnName = "PRODUCTCODE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ORDERNUMBER", referencedColumnName = "ORDERNUMBER", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderdetailsPK) {
        this.orderDetailsPK = orderdetailsPK;
    }

    public OrderDetail(int ordernumber, String productcode) {
        this.orderDetailsPK = new OrderDetailPK(ordernumber, productcode);
    }

    public OrderDetailPK getOrderDetailsPK() {
        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public Short getOrderlinenumber() {
        return orderlinenumber;
    }

    public void setOrderlinenumber(Short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailsPK != null ? orderDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailsPK == null && other.orderDetailsPK != null) || (this.orderDetailsPK != null && !this.orderDetailsPK.equals(other.orderDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Orderdetails[ orderDetailsPK=" + orderDetailsPK + " ]";
    }
}
