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
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "product_numeric_feature")
@NamedQueries({
    @NamedQuery(name = "ProductNumericFeature.findAll", query = "SELECT p FROM ProductNumericFeature p")})
public class ProductNumericFeature implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "value")
    private Double value;
    
    @ManyToOne
    @JoinColumn(name = "feature_id", referencedColumnName = "id")
    private NumericFeature numericFeature;
//    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Product product;

    public ProductNumericFeature() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    



    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public NumericFeature getNumericFeature() {
        return numericFeature;
    }

    public void setNumericFeature(NumericFeature numericFeature) {
        this.numericFeature = numericFeature;
    }

    

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductNumericFeature)) {
            return false;
        }
        ProductNumericFeature other = (ProductNumericFeature) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.ProductNumericFeature[ id=" + id + " ]";
    }
    
}
