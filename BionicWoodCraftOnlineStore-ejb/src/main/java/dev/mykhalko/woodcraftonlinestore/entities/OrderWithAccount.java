/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "order_with_account")
@DiscriminatorValue("OrderWithAccount")
@PrimaryKeyJoinColumn(name="basic_order_id", referencedColumnName = "id")
@NamedQueries({
    @NamedQuery(name = "OrderWithAccount.findAll", query = "SELECT o FROM OrderWithAccount o"),
    @NamedQuery(name = "OrderWithAccount.findByStatus", query = "SELECT o FROM OrderWithAccount o WHERE o.orderStatus=:status")
})
public class OrderWithAccount extends BasicOrder implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "basic_order_id")
//    private Long basicOrderId;
    
//    @JoinColumn(name = "basic_order_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private BasicOrder basicOrder;
    
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public OrderWithAccount() {
    }

//    public OrderWithAccount(Long basicOrderId) {
//        this.basicOrderId = basicOrderId;
//    }
//
//    public Long getBasicOrderId() {
//        return basicOrderId;
//    }

//    public void setBasicOrderId(Long basicOrderId) {
//        this.basicOrderId = basicOrderId;
//    }
//
//    public BasicOrder getBasicOrder() {
//        return basicOrder;
//    }

//    public void setBasicOrder(BasicOrder basicOrder) {
//        this.basicOrder = basicOrder;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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
//        if (!(object instanceof OrderWithAccount)) {
//            return false;
//        }
//        OrderWithAccount other = (OrderWithAccount) object;
//        if ((this.basicOrderId == null && other.basicOrderId != null) || (this.basicOrderId != null && !this.basicOrderId.equals(other.basicOrderId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount[ OrderId=" + getId() + " ]";
    }
    
}
