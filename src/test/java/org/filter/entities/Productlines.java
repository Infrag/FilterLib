/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.filter.entities;

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
public class Productlines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTLINE", nullable = false, length = 50)
    private String productline;
    @Column(name = "TEXTDESCRIPTION", length = 4000)
    private String textdescription;
    @Lob
    @Column(name = "HTMLDESCRIPTION")
    private String htmldescription;
    @Lob
    @Column(name = "IMAGE")
    private Serializable image;

    public Productlines() {
    }

    public Productlines(String productline) {
        this.productline = productline;
    }

    public String getProductline() {
        return productline;
    }

    public void setProductline(String productline) {
        this.productline = productline;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
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
        hash += (productline != null ? productline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productlines)) {
            return false;
        }
        Productlines other = (Productlines) object;
        if ((this.productline == null && other.productline != null) || (this.productline != null && !this.productline.equals(other.productline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Productlines[ productline=" + productline + " ]";
    }
    
}
