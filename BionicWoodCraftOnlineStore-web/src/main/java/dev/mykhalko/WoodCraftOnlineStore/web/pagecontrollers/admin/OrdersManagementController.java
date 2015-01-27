/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers.admin;

import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.OrderWithAccountFacade;
import dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mrgibbs
 */
@Named(value = "ordersManagementController")
@RequestScoped
public class OrdersManagementController {
    @EJB
    private OrderWithAccountFacade orderWithAccountFacade;
    
    private String ordersType;
    private String pageHeader;
    private List<OrderWithAccount> orders;
    /**
     * Creates a new instance of OrdersManagementController
     */
    public OrdersManagementController() {
    }
    
    public void prepareData(){
        orders = new ArrayList<>();
        switch(ordersType){
            case "all":
                pageHeader = "Всі замовлення";
                orders.addAll(orderWithAccountFacade.findAll());
                break;
            case "unviewed":
                pageHeader = "Нові замовлення";
                orders.addAll(orderWithAccountFacade.findOrdersByStatus(OrderStatus.UNVIEWED));
                break;
            case "viewed":
                pageHeader = "Переглянуті замовлення";
                orders = new ArrayList<>();
                orders.addAll(orderWithAccountFacade.findOrdersByStatus(OrderStatus.COMPLETED));
                orders.addAll(orderWithAccountFacade.findOrdersByStatus(OrderStatus.EJECTED));
                orders.addAll(orderWithAccountFacade.findOrdersByStatus(OrderStatus.CONFIRMED));
                break;
            default:
                pageHeader = "Помилка. Неправильна адреса сторінки";
        }
    }

    public String getOrdersType() {
        return ordersType;
    }

    public void setOrdersType(String ordersType) {
        this.ordersType = ordersType;
    }

    public List<OrderWithAccount> getOrders() {
        return orders;
    }

    public String getPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }
    
    
    
}
