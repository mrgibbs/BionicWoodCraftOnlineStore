/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers.admin;

import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.OrderWithAccountFacade;
import dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mrgibbs
 */
@Named(value = "adminOrderPageController")
@RequestScoped
public class AdminOrderPageController {
    @EJB
    private OrderWithAccountFacade orderWithAccountFacade;
    
    private OrderWithAccount order;
    private String orderIdUrl;
    
    /**
     * Creates a new instance of AdminOrderPageController
     */
    public AdminOrderPageController() {
    }

    public OrderWithAccount getOrder() {
        return order;
    }
    
    public void prepareData() {
        order = orderWithAccountFacade.find(Long.parseLong(orderIdUrl));        
    }

    public void setOrder(OrderWithAccount order) {
        this.order = order;
    }

    

    public String getOrderIdUrl() {
        return orderIdUrl;
    }

    public void setOrderIdUrl(String orderIdUrl) {
        this.orderIdUrl = orderIdUrl;
    }
    
    public OrderStatus[] getStatuses(){
        return OrderStatus.values();
    }
    
    public void changeOrderStatus(){
        orderWithAccountFacade.edit(order);
    }
    
}
