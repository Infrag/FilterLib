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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "PRODUCTLINES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PRODUCTLINE"})})
@NamedQueries({
    @NamedQuery(name = "Productlines.findAll", query = "SELECT p FROM Productlines p"),
    @NamedQuery(name = "Productlines.findByProductline", query = "SELECT p FROM Productlines p WHERE p.productline = :productline"),
    @NamedQuery(name = "Productlines.findByTextdescription", query = "SELECT p FROM Productlines p WHERE p.textdescription = :textdescription")})
public class ProductLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTLINE", nullable = false, length = 50)
    private String productLine;
    @Column(name = "TEXTDESCRIPTION", length = 4000)
    private String textDescription;
    @Lob
    @Column(name = "HTMLDESCRIPTION")
    private String htmlDescription;
    @Lob
    @Column(name = "IMAGE")
    private Serializable image;

    public ProductLine() {
    }

    public ProductLine(String productline) {
        this.productLine = productline;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productLine != null ? productLine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductLine)) {
            return false;
        }
        ProductLine other = (ProductLine) object;
        if ((this.productLine == null && other.productLine != null) || (this.productLine != null && !this.productLine.equals(other.productLine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Productline[ productline=" + productLine + " ]";
    }
}
