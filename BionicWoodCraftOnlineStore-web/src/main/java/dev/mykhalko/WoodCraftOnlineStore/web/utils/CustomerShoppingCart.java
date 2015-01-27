/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.utils;

import dev.mykhalko.woodcraftonlinestore.ejb.logic.ShoppingCart;
import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import dev.mykhalko.woodcraftonlinestore.entities.OrderLine;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

/**
 *
 * @author mrgibbs
 */
@Named(value = "customerShoppingCart")
@SessionScoped
public class CustomerShoppingCart implements Serializable {
    @EJB
    private ShoppingCart shoppingCart;
    
    
    
    private List<OrderLine> orderLines;
    private Product currentProduct;
    private int currentProductAmount;
    private int totalProductsAmount;
    private double totalPrice;
//    private Customer customer;
//    private boolean cartEmpty;
    /**
     * Creates a new instance of CustomerShoppingCart
     */
    public CustomerShoppingCart() {
        currentProduct = null;
        currentProductAmount = 1;
        totalProductsAmount = 0;
//        customer = null;
        System.out.println("Created new instance of ShoppingCart");
    }
    
    public void addItemToShoppingCart() {
        if (currentProduct != null && currentProductAmount > 0) {
            shoppingCart.addLine(currentProduct, currentProductAmount);
            totalProductsAmount = shoppingCart.getTotalProductsAmount();
            orderLines = shoppingCart.getCartLines();
        }
        currentProductAmount = 1;
    }
    
    public void clear(){
        shoppingCart.clear();
        orderLines.clear();
    }
    
    public void update(){
        
    }
    
//    public String checkout(){
//        
////        TODO     write this method
//        
//        return null;
//    }
    
    public void attrListener(ActionEvent event) {
        currentProduct = (Product)event.getComponent().getAttributes().get("currentProduct");
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public int getCurrentProductAmount() {
        return currentProductAmount;
    }

    public void setCurrentProductAmount(int currentProductAmount) {
        this.currentProductAmount = currentProductAmount;
    }

    public int getTotalProductsAmount() {
        totalProductsAmount = shoppingCart.getTotalProductsAmount();
        return totalProductsAmount;
    }

    public boolean isCartEmpty() {
        return getTotalProductsAmount() < 1;
    }     

    public double getTotalPrice() { 
        totalPrice = shoppingCart.getTotalPrice();
        return totalPrice;
    }
    
    
}
