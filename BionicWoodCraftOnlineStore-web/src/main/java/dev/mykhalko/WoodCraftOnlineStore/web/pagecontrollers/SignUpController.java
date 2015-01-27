/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.CustomerFacade;
import dev.mykhalko.woodcraftonlinestore.ejb.security.PasswordEncryptorLocal;
import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import dev.mykhalko.woodcraftonlinestore.helpers.HashInfo;
import dev.mykhalko.woodcraftonlinestore.helpers.UserStatus;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.validation.ValidationException;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Named(value = "signUpController")
@ViewScoped
public class SignUpController implements Serializable{
    @EJB
    private CustomerFacade customerFacade;
    @EJB
    private PasswordEncryptorLocal passwordEncryptorSHA256;
    
    @Inject
    InfoPageController infoPageController;
    
    
    
    
    
    private static final String passVerificationErrorMsg = "Паролі відрізняються";
    
    private Customer customer;
    
    @Size(min = 6, message = "Пароль має містити принаймні {min} символів")
    private String source_password;
    
    
    private String source_password_repeat;
    
    
    
//    @Size(min=5, max=10, message = "Lukas Podolsky")
//    @Pattern(regexp = "[A-Za-z]+", message = "Pattern not correct")
//    private String testField;
    
    
    public SignUpController() {
        customer = new Customer();
        System.out.println("New customer created");
    }
    
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSource_password() {
        return source_password;
    }

    public void setSource_password(String source_password) {
        this.source_password = source_password;
    }

    public String getSource_password_repeat() {
        return source_password_repeat;
    }

    public void setSource_password_repeat(String source_password_repeat) {
        if (source_password_repeat != null && !source_password_repeat.equals(this.source_password)) {
//            throw new ValidatoException(new FacesMessage("Паролі відрізняються"));
            throw new ValidationException("Паролі відрізняються");
        }
        this.source_password_repeat = source_password_repeat;
    }

//    public String getTestField() {
//        return testField;
//    }
//
//    public void setTestField(String testField) {
////        System.out.println("Bugaga !!!!! " + testField);
//        this.testField = testField;
//    }
    
    
//    public void passVerification() {
//        FacesContext.getCurrentInstance().
//    }
    
    public void passVerification(FacesContext context, UIComponent component, Object value) { 
        String pass2 = (String) value;
        String pass1 = source_password;        
//        System.out.println("name = " + customer.getName() + "    surname = " + customer.getSurname());
//
//        System.out.println("From validator in backing bean:   pass1 = " + pass1);
//        System.out.println("From validator in backing bean:   pass2 = " + pass2);
        //System.out.println("Attributes: " + component.getAttributes().keySet());

        if (pass2 == null || pass1 == null) {
            throw new ValidatorException(new FacesMessage(passVerificationErrorMsg));
        }

        if (!pass1.equals(pass2)) {
            throw new ValidatorException(new FacesMessage(passVerificationErrorMsg));
        }
    }
    
    public String signUp() {
        customer.setUserStatus(UserStatus.ACTIVE);
        
        HashInfo hashInfo = passwordEncryptorSHA256.encrypt(source_password);
        customer.setHashpass(hashInfo.getHasspass().toUpperCase());
        customer.setHashsalt(hashInfo.getHashsalt());
        
        customerFacade.create(customer);
        
        infoPageController.setInfoPageType(InfoPageType.SUCCESS);
        infoPageController.setMessage("Ви успішно зареєструвались");
        return "/WEB-INF/pages/public/info_page.xhtml";
        
    }
    
    
}
