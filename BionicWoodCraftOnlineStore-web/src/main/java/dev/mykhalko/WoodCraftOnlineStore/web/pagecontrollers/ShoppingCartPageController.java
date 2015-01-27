/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.controllers.UserManager;
import dev.mykhalko.WoodCraftOnlineStore.web.utils.CustomerShoppingCart;
import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import dev.mykhalko.woodcraftonlinestore.ejb.logic.OrderManager;
import dev.mykhalko.woodcraftonlinestore.entities.OrderLine;
import dev.mykhalko.woodcraftonlinestore.helpers.DeliveryType;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author mrgibbs
 */
@Named(value = "shoppingCartPageController")
@RequestScoped
public class ShoppingCartPageController {
    @Inject
    private UserManager userManager;
    @EJB
    private OrderManager orderManager;
    @Inject
    private InfoPageController infoPageController;
    @Inject
    private CustomerShoppingCart customerShoppingCart;
    
    private DeliveryType deliveryType;
    
    /**
     * Creates a new instance of ShoppingCartPageController
     */
    public ShoppingCartPageController() {
        deliveryType = DeliveryType.NO_DELIVERY;
//        System.out.println("cartPageController created");
    }
    
//    @PreDestroy
//    public void predestroymethod(){
//        System.out.println("cartPageController destroyed");
//    }
    
    public String checkout(){
        if (userManager.isAuthenticated()) {
            List<OrderLine> lines = customerShoppingCart.getOrderLines();
//            System.out.println("Order lines in checkout: " + lines);
            orderManager.checkoutOrderWithAccount(userManager.getCustomer(), deliveryType, lines);
            customerShoppingCart.clear();
            infoPageController.setInfoPageType(InfoPageType.SUCCESS);
            infoPageController.setMessage("Замовлення оформлено успішно!");
        } else {
            infoPageController.setInfoPageType(InfoPageType.ERROR);
            infoPageController.setMessage("Помилка. Щоб зробити замовлення потрібно увійти.");
        }
        return "info_page.xhtml";      
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
    
    
}
