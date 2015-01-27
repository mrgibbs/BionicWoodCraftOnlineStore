/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.security;

import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.CustomerFacade;
import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.NoResultException;

/**
 *
 * @author mrgibbs
 */
@Stateless
@LocalBean
public class AuthenticationBean {
    @EJB
    private PasswordEncryptorLocal passwordEncryptorSHA256;
    @EJB
    private CustomerFacade customerFacade;
    
    
    
    public boolean checkCustomerCredentials(String email, String password) {
        Customer customer = null;
        try {
            customer = customerFacade.findByEmail(email);
        } catch(NoResultException e) {
            System.out.println("Customer not found");
            return false;
        }
        return customer.getHashpass().equals(password);       
    }
    
    public Customer getCustomerByCredentials(String email, String password) {
        Customer customer = null;
        try {
            customer = customerFacade.findByEmail(email);
        } catch(NoResultException e) {
            System.out.println("Customer not found");
            return null;
        }
        if(customer == null) {
            return null;
        }
        
        String hashsalt = customer.getHashsalt();
        String hashpassword = passwordEncryptorSHA256.encrypt(password, hashsalt);
        System.out.println("hashpassword: " + hashpassword);
        
        if (customer.getHashpass().equals(hashpassword)) {
            //customer.setHashpass("");
            //customer.setHashsalt("");
            return customer;
        } else {
            return null;
        }   
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
