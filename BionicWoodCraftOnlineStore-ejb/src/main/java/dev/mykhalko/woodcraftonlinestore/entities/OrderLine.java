/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "order_line")
@NamedQueries({
    @NamedQuery(name = "OrderLine.findAll", query = "SELECT o FROM OrderLine o")})
public class OrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_price")
    private Float productPrice;
//    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private BasicOrder basicOrder;
    
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;

    public OrderLine() {
    }
    
    public OrderLine(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

//    public OrderLine(OrderLinePK orderLinePK) {
//        this.orderLinePK = orderLinePK;
//    }
//
//    public OrderLine(OrderLinePK orderLinePK, int amount, String productPrice) {
//        this.orderLinePK = orderLinePK;
//        this.amount = amount;
//        this.productPrice = productPrice;
//    }
//
//    public OrderLine(long id, long orderId, long productId) {
//        this.orderLinePK = new OrderLinePK(id, orderId, productId);
//    }
//
//    public OrderLinePK getOrderLinePK() {
//        return orderLinePK;
//    }
//
//    public void setOrderLinePK(OrderLinePK orderLinePK) {
//        this.orderLinePK = orderLinePK;
//    }

    public int getAmount() {
        return amount;
    }
    
    

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

//    public BasicOrder getBasicOrder() {
//        return basicOrder;
//    }
//
//    public void setBasicOrder(BasicOrder basicOrder) {
//        this.basicOrder = basicOrder;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof OrderLine)) {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.OrderLine[ id=" + id + " ]";
    }
    
}
