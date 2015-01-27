/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.controllers;

import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.CustomerFacade;
import dev.mykhalko.woodcraftonlinestore.ejb.security.AuthenticationBean;
import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mrgibbs
 */
@Named(value = "userManager")
@SessionScoped
public class UserManager implements Serializable {
    @EJB
    private AuthenticationBean authenticationBean;
    
//    private String test = "testing";
    
    private Customer customer;
    private boolean authenticated;
    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
        System.out.println("Created new instance of UserManager");
    }
    
    public boolean login(String email, String password) {
        customer = null;
        customer = authenticationBean.getCustomerByCredentials(email, password);
        if (customer != null) {
            authenticated = true;
        }
        return customer != null;
    }
    
    public void logout() {
        customer = null;
        authenticated = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getInitParameter("app_uri") + "/home");
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public String getTest() {
//        return test;
//    }
//
//    public void setTest(String test) {
//        this.test = test;
//    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    
    
    
    
}
