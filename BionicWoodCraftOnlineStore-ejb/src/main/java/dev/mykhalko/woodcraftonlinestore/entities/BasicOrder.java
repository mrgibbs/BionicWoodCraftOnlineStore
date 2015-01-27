/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.helpers.DeliveryType;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "basic_order")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "order_type", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
    @NamedQuery(name = "BasicOrder.findAll", query = "SELECT b FROM BasicOrder b")})
public class BasicOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Basic(optional = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;
    
    @Basic(optional = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;
    
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
//    @Column(name = "order_type")
//    private String orderType;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "basicOrder")
//    private OrderWithoutAccount orderWithoutAccount;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "basicOrder")
//    private OrderWithAccount orderWithAccount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLineList;
    
//    @Transient
//    double totalSum;

    public BasicOrder() {
    }

    public BasicOrder(Long id) {
        this.id = id;
    }

    public BasicOrder(Long id, Date dateCreated, OrderStatus status, DeliveryType deliveryType) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.orderStatus = status;
        this.deliveryType = deliveryType;
        //this.orderType = orderType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public double getTotalSum(){
        double totalSum = 0.0;
        if (orderLineList == null || orderLineList.isEmpty()) {
            totalSum = 0.0;
        } else {
            for (OrderLine line : orderLineList) {
                totalSum += line.getAmount() * line.getProductPrice();
            }
        }
        return totalSum;
    }

    

//    public String getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(String orderType) {
//        this.orderType = orderType;
//    }
//
//    public OrderWithoutAccount getOrderWithoutAccount() {
//        return orderWithoutAccount;
//    }
//
//    public void setOrderWithoutAccount(OrderWithoutAccount orderWithoutAccount) {
//        this.orderWithoutAccount = orderWithoutAccount;
//    }
//
//    public OrderWithAccount getOrderWithAccount() {
//        return orderWithAccount;
//    }
//
//    public void setOrderWithAccount(OrderWithAccount orderWithAccount) {
//        this.orderWithAccount = orderWithAccount;
//    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasicOrder)) {
            return false;
        }
        BasicOrder other = (BasicOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.BasicOrder[ id=" + id + " ]";
    }
    
}
