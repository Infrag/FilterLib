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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author infragile
 */
@Entity
@Table(name = "EMPLOYEES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EMPLOYEENUMBER"})})
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeenumber", query = "SELECT e FROM Employee e WHERE e.employeenumber = :employeenumber"),
    @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findByExtension", query = "SELECT e FROM Employee e WHERE e.extension = :extension"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByOfficecode", query = "SELECT e FROM Employee e WHERE e.officecode = :officecode"),
    @NamedQuery(name = "Employee.findByReportsto", query = "SELECT e FROM Employee e WHERE e.reportsto = :reportsto"),
    @NamedQuery(name = "Employee.findByJobtitle", query = "SELECT e FROM Employee e WHERE e.jobtitle = :jobtitle")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEENUMBER", nullable = false)
    private Integer employeenumber;
    @Column(name = "LASTNAME", length = 50)
    private String lastname;
    @Column(name = "FIRSTNAME", length = 50)
    private String firstname;
    @Column(name = "EXTENSION", length = 10)
    private String extension;
    @Column(name = "EMAIL", length = 100)
    private String email;
    @Column(name = "OFFICECODE", length = 10)
    private String officecode;
    @Column(name = "REPORTSTO")
    private Integer reportsto;
    @Column(name = "JOBTITLE", length = 50)
    private String jobtitle;

    public Employee() {
    }

    public Employee(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public Integer getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Integer employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficecode() {
        return officecode;
    }

    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }

    public Integer getReportsto() {
        return reportsto;
    }

    public void setReportsto(Integer reportsto) {
        this.reportsto = reportsto;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeenumber != null ? employeenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeenumber == null && other.employeenumber != null) || (this.employeenumber != null && !this.employeenumber.equals(other.employeenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.filter.dao.entities.Employees[ employeenumber=" + employeenumber + " ]";
    }
    
}
