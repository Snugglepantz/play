package me.slashfix;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burni_000
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Person.findAll", query = "SELECT c FROM Customer c"),
  @NamedQuery(name = "Person.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
  @NamedQuery(name = "Person.findByName", query = "SELECT c FROM Customer c WHERE c.name LIKE :name"),
  @NamedQuery(name = "Person.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
  @NamedQuery(name = "Person.findByState", query = "SELECT c FROM Customer c WHERE c.state = :state")})
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CUSTOMER_ID")
  @GeneratedValue
  private Integer customerId;
  @Size(max = 30)
  @Column(name = "NAME")
  private String name;
  @Size(max = 25)
  @Column(name = "CITY")
  private String city;
  @Size(max = 2)
  @Column(name = "STATE")
  private String state;

  public Customer() {
  }

  public Customer(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (customerId != null ? customerId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Customer)) {
      return false;
    }
    Customer other = (Customer) object;
    if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "me.slashfix.Customer[ customerId=" + customerId + " ]";
  }

}
