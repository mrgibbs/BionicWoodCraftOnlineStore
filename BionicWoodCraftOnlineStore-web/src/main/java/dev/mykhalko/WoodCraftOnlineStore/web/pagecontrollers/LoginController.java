/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.controllers.UserManager;
import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author mrgibbs
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {
    private String email;
    private String password;
    
    
    @Inject
    private InfoPageController infoPageController;
    @Inject
    private UserManager userManager;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public String login(){
//        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
//        UserManager um = (UserManager) FacesContext.getCurrentInstance().getApplication()
//                .getELResolver().getValue(elContext, null, "userManager");
//        
//        if (um == null){
//            System.out.println("user Manager is null !!!");
//            return "login_failed.xhtml";
//        }
//        if (um.login(email, password)) {
//            return "login_succeeded.xhtml";
//        }
//        return "login_failed.xhtml";
        
        
        if (userManager == null){
            infoPageController.setInfoPageType(InfoPageType.ERROR);
            infoPageController.setMessage("Внутрішня серверна помилка. Зверніться до адміністратора");
            return "info_page.xhtml";
        }
        if (userManager.login(email, password)) {
            infoPageController.setInfoPageType(InfoPageType.SUCCESS);
            infoPageController.setMessage("Ви успішно увійшли");
            return "info_page.xhtml";
        }
        infoPageController.setInfoPageType(InfoPageType.ERROR);
        infoPageController.setMessage("Не вдалося увійти. Ви ввели неправильні дані. Спробуйте ще раз.");
        return "info_page.xhtml";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }
    
    
    
    
    
}
