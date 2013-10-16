/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.obozek.filterlib.test.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author infragile
 */
@Embeddable
public class OrderDetailPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "ORDERNUMBER", nullable = false)
    private int orderNumber;
    @Basic(optional = false)
    @Column(name = "PRODUCTCODE", nullable = false, length = 15)
    private String productCode;

    public OrderDetailPK()
    {
    }

    public OrderDetailPK(int ordernumber, String productCode)
    {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(String productCode)
    {
        this.productCode = productCode;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) orderNumber;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetailPK)) {
            return false;
        }
        OrderDetailPK other = (OrderDetailPK) object;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if ((this.productCode == null && other.productCode != null) || (this.productCode != null && !this.productCode.equals(other.productCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.filter.dao.entities.OrderdetailsPK[ ordernumber=" + orderNumber + ", productcode=" + productCode + " ]";
    }
}
