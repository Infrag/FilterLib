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
    @NamedQuery(name = "OrderDetail.findByOrdernumber", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.orderNumber = :orderNumber"),
    @NamedQuery(name = "OrderDetail.findByProductcode", query = "SELECT o FROM OrderDetail o WHERE o.orderDetailPK.productCode = :produtCode"),
    @NamedQuery(name = "OrderDetail.findByQuantityordered", query = "SELECT o FROM OrderDetail o WHERE o.quantityOrdered = :quantityordered"),
    @NamedQuery(name = "OrderDetail.findByPriceeach", query = "SELECT o FROM OrderDetail o WHERE o.priceEach = :priceEach"),
    @NamedQuery(name = "OrderDetail.findByOrderlinenumber", query = "SELECT o FROM OrderDetail o WHERE o.orderlineNumber = :orderlinenumber")})
public class OrderDetail implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderDetailPK orderDetailPK;
    @Column(name = "QUANTITYORDERED")
    private Integer quantityOrdered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICEEACH", precision = 52)
    private Double priceEach;
    @Column(name = "ORDERLINENUMBER")
    private Short orderlineNumber;
    @JoinColumn(name = "PRODUCTCODE", referencedColumnName = "PRODUCTCODE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ORDERNUMBER", referencedColumnName = "ORDERNUMBER", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;

    public OrderDetail()
    {
    }

    public OrderDetail(OrderDetailPK orderdetailsPK)
    {
        this.orderDetailPK = orderdetailsPK;
    }

    public OrderDetail(int ordernumber, String productcode)
    {
        this.orderDetailPK = new OrderDetailPK(ordernumber, productcode);
    }

    public OrderDetailPK getOrderDetailPK()
    {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK)
    {
        this.orderDetailPK = orderDetailPK;
    }

    public Integer getQuantityOrdered()
    {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered)
    {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getPriceEach()
    {
        return priceEach;
    }

    public void setPriceEach(Double priceEach)
    {
        this.priceEach = priceEach;
    }

    public Short getOrderlineNumber()
    {
        return orderlineNumber;
    }

    public void setOrderlineNumber(Short orderlineNumber)
    {
        this.orderlineNumber = orderlineNumber;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (orderDetailPK != null ? orderDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.orderDetailPK == null && other.orderDetailPK != null) || (this.orderDetailPK != null && !this.orderDetailPK.equals(other.orderDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.filter.dao.entities.Orderdetails[ orderDetailsPK=" + orderDetailPK + " ]";
    }
}
