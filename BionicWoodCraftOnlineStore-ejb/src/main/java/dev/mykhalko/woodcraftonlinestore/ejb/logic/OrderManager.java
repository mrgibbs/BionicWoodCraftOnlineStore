/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.logic;

import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.OrderWithAccountFacade;
import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import dev.mykhalko.woodcraftonlinestore.entities.OrderLine;
import dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount;
import dev.mykhalko.woodcraftonlinestore.helpers.DeliveryType;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import java.util.Date;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.inject.Inject;

/**
 *
 * @author mrgibbs
 */
@Stateful
@LocalBean
public class OrderManager {
//    @Inject 
//    ShoppingCart shoppingCart;
    @Inject
    private OrderWithAccountFacade orderWithAccountFacade;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public OrderManager() {
        System.out.println("EJB OrderManager was created");
        
    }
    
    @PreDestroy
    public void sq(){
        System.out.println("EJB OrderManager was destroyed");
    }
    
    public void checkoutOrderWithAccount(Customer customer, DeliveryType dtype, List<OrderLine> lines) {
        OrderWithAccount order = new OrderWithAccount();
        order.setCustomer(customer);
        order.setDateCreated(new Date());
        order.setDeliveryType(dtype);
        order.setOrderStatus(OrderStatus.UNVIEWED);
        
//        List<OrderLine> lines = shoppingCart.getCartLines();
        for (OrderLine line : lines){
            line.setProductPrice(line.getProduct().getPrice());
        }
//        System.out.println("Lines: " + lines);
        order.setOrderLineList(lines);
        orderWithAccountFacade.create(order);
//        shoppingCart.clear();
    }
}
