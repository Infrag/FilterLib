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
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductcode", query = "SELECT p FROM Product p WHERE p.code = :code"),
    @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByProductline", query = "SELECT p FROM Product p WHERE p.productLine = :productLine"),
    @NamedQuery(name = "Product.findByProductcale", query = "SELECT p FROM Product p WHERE p.scale = :scale"),
    @NamedQuery(name = "Product.findByProductvendor", query = "SELECT p FROM Product p WHERE p.vendor = :vendor"),
    @NamedQuery(name = "Product.findByQuantityinstock", query = "SELECT p FROM Product p WHERE p.quantityInStock = :quantityInStock"),
    @NamedQuery(name = "Product.findByBuyprice", query = "SELECT p FROM Product p WHERE p.buyPrice = :buyPrice"),
    @NamedQuery(name = "Product.findByMsrp", query = "SELECT p FROM Product p WHERE p.msrp = :msrp")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTCODE", nullable = false, length = 15)
    private String code;
    @Column(name = "PRODUCTNAME", length = 70)
    private String name;
    @Column(name = "PRODUCTLINE", length = 50)
    private String productLine;
    @Column(name = "PRODUCTSCALE", length = 10)
    private String scale;
    @Column(name = "PRODUCTVENDOR", length = 50)
    private String vendor;
    @Lob
    @Column(name = "PRODUCTDESCRIPTION", length = 32700)
    private String description;
    @Column(name = "QUANTITYINSTOCK")
    private Integer quantityInStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BUYPRICE", precision = 52)
    private Double buyPrice;
    @Column(name = "MSRP", precision = 52)
    private Double msrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderDetail> orderDetailList;

    public Product() {
    }

    public Product(String productcode) {
        this.code = productcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Products[ productcode=" + code + " ]";
    }
}
