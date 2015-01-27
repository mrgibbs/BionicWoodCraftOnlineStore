/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.helpers.UserStatus;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByEmail",
            query = "SELECT c FROM Customer c where c.email=:email")
})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final String lengthMsg = "Поле може містити від {min} до {max} символів";
    private static final String notEmptyMsg = "Поле не може бути пустим";
    private static final String nameErrorMsg = "Некоректне ім'я";
    private static final String surnameErrorMsg = "Некоректне прізвище";
    private static final String emailErrorMsg = "Некоректна електронна пошта";
    private static final String phoneErrorMsg = "Некоректний номер";
    private static final String nameRegex = "[А-Яа-яA-Za-zіІїЇєЄ' -]+";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull(message = notEmptyMsg)
    @Size(min = 1, max = 45, message = lengthMsg)
    @Pattern(regexp = nameRegex, message = nameErrorMsg)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull(message = notEmptyMsg)
    @Size(min = 1, max = 45, message = lengthMsg)
    @Pattern(regexp = nameRegex, message = surnameErrorMsg)
    @Column(name = "surname")
    private String surname;
    
    @Basic(optional = false)
    @NotNull(message = notEmptyMsg)
    @Size(min = 64, max = 64)
    @Pattern(regexp = "[0-9ABCDEF]{64}")
    @Column(name = "hashpass")
    private String hashpass;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "hashsalt")
    private String hashsalt;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = emailErrorMsg)//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    
    @Size(max = 30)
    @Pattern(regexp = "[0-9 -]{5,30}", message = phoneErrorMsg)
    @Column(name = "phone")
    private String phone;
    
    @Basic(optional = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus userStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Address> addressList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<OrderWithAccount> orderWithAccountList;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<ProductComment> productCommentList;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, String name, String surname, String hashpass, String hashsalt, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hashpass = hashpass;
        this.hashsalt = hashsalt;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHashpass() {
        return hashpass;
    }

    public void setHashpass(String hashpass) {
        this.hashpass = hashpass;
    }

    public String getHashsalt() {
        return hashsalt;
    }

    public void setHashsalt(String hashsalt) {
        this.hashsalt = hashsalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<OrderWithAccount> getOrderWithAccountList() {
        return orderWithAccountList;
    }

    public void setOrderWithAccountList(List<OrderWithAccount> orderWithAccountList) {
        this.orderWithAccountList = orderWithAccountList;
    }

    public List<ProductComment> getProductCommentList() {
        return productCommentList;
    }

    public void setProductCommentList(List<ProductComment> productCommentList) {
        this.productCommentList = productCommentList;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.Customer[ id=" + id + " ]";
    }
    
}
