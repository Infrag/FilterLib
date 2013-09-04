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
import javax.persistence.Lob;
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
@Table(name = "PRODUCTS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PRODUCTCODE"})})
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductcode", query = "SELECT p FROM Products p WHERE p.productcode = :productcode"),
    @NamedQuery(name = "Products.findByProductname", query = "SELECT p FROM Products p WHERE p.productname = :productname"),
    @NamedQuery(name = "Products.findByProductline", query = "SELECT p FROM Products p WHERE p.productline = :productline"),
    @NamedQuery(name = "Products.findByProductscale", query = "SELECT p FROM Products p WHERE p.productscale = :productscale"),
    @NamedQuery(name = "Products.findByProductvendor", query = "SELECT p FROM Products p WHERE p.productvendor = :productvendor"),
    @NamedQuery(name = "Products.findByQuantityinstock", query = "SELECT p FROM Products p WHERE p.quantityinstock = :quantityinstock"),
    @NamedQuery(name = "Products.findByBuyprice", query = "SELECT p FROM Products p WHERE p.buyprice = :buyprice"),
    @NamedQuery(name = "Products.findByMsrp", query = "SELECT p FROM Products p WHERE p.msrp = :msrp")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTCODE", nullable = false, length = 15)
    private String productcode;
    @Column(name = "PRODUCTNAME", length = 70)
    private String productname;
    @Column(name = "PRODUCTLINE", length = 50)
    private String productline;
    @Column(name = "PRODUCTSCALE", length = 10)
    private String productscale;
    @Column(name = "PRODUCTVENDOR", length = 50)
    private String productvendor;
    @Lob
    @Column(name = "PRODUCTDESCRIPTION", length = 32700)
    private String productdescription;
    @Column(name = "QUANTITYINSTOCK")
    private Integer quantityinstock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BUYPRICE", precision = 52)
    private Double buyprice;
    @Column(name = "MSRP", precision = 52)
    private Double msrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Orderdetails> orderdetailsList;

    public Products() {
    }

    public Products(String productcode) {
        this.productcode = productcode;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getProductscale() {
        return productscale;
    }

    public void setProductscale(String productscale) {
        this.productscale = productscale;
    }

    public String getProductvendor() {
        return productvendor;
    }

    public void setProductvendor(String productvendor) {
        this.productvendor = productvendor;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public Integer getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(Integer quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    public Double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(Double buyprice) {
        this.buyprice = buyprice;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productcode != null ? productcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productcode == null && other.productcode != null) || (this.productcode != null && !this.productcode.equals(other.productcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Products[ productcode=" + productcode + " ]";
    }
    
}
