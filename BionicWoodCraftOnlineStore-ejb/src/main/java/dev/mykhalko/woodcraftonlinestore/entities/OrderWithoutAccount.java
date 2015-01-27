/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "order_without_account")
@DiscriminatorValue("OrderWithoutAccount")
@NamedQueries({
    @NamedQuery(name = "OrderWithoutAccount.findAll", query = "SELECT o FROM OrderWithoutAccount o")})
public class OrderWithoutAccount extends BasicOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "phone")
    private String phone;
    
// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    
//    @Size(max = 100)
//    @Column(name = "delivery_address")
//    private String deliveryAddress;

//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "basic_order_id")
//    private Long basicOrderId;
    
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Address address;
    
//    @JoinColumn(name = "basic_order_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private BasicOrder basicOrder;

    public OrderWithoutAccount() {
    }

//    public OrderWithoutAccount(Long basicOrderId) {
//        this.basicOrderId = basicOrderId;
//    }
//
    public OrderWithoutAccount(String phone, String email) {
        //this.basicOrderId = basicOrderId;
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getDeliveryAddress() {
//        return deliveryAddress;
//    }
//
//    public void setDeliveryAddress(String deliveryAddress) {
//        this.deliveryAddress = deliveryAddress;
//    }

//    public Long getBasicOrderId() {
//        return basicOrderId;
//    }
//
//    public void setBasicOrderId(Long basicOrderId) {
//        this.basicOrderId = basicOrderId;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public BasicOrder getBasicOrder() {
//        return basicOrder;
//    }
//
//    public void setBasicOrder(BasicOrder basicOrder) {
//        this.basicOrder = basicOrder;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (basicOrderId != null ? basicOrderId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof OrderWithoutAccount)) {
//            return false;
//        }
//        OrderWithoutAccount other = (OrderWithoutAccount) object;
//        if ((this.basicOrderId == null && other.basicOrderId != null) || (this.basicOrderId != null && !this.basicOrderId.equals(other.basicOrderId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.OrderWithoutAccount[ OrderId=" + getId() + " ]";
    }
    
}
