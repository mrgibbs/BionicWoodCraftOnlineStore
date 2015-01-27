/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mrgibbs
 */
@Named(value = "infoPageController")
@RequestScoped
public class InfoPageController {
    private String message;
    private InfoPageType infoPageType;
    /**
     * Creates a new instance of InfoPageController
     */
    public InfoPageController() {
//        System.out.println("infoPageController created");
    }
    
//    @PreDestroy
//    public void predestroymethod(){
//        System.out.println("infoPageController destroyed");
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InfoPageType getInfoPageType() {
        return infoPageType;
    }
    
    public String getInfoPageLowerCase() {
        return infoPageType.toString().toLowerCase();
    }

    public void setInfoPageType(InfoPageType infoPageType) {
        this.infoPageType = infoPageType;
    }
    
}
