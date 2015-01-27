/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.logic;

import dev.mykhalko.woodcraftonlinestore.entities.OrderLine;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author mrgibbs
 */
@Stateful
@LocalBean
public class ShoppingCart {
    
    private List<OrderLine> cartLines;
    
    public ShoppingCart(){
        cartLines = new ArrayList<>();
        System.out.println("EJB Shopping Cart created");
    }
    
    @PreDestroy
    public void sq(){
        System.out.println("EJB Shopping cart was destroyed " + cartLines);
    }

    public void addLine(Product product, int amount) {
        int currentLineIndex = getLineIndex(product);
        
        if (currentLineIndex == -1) {
            cartLines.add(new OrderLine(product, amount));
        } else {
            int old_amount = cartLines.get(currentLineIndex).getAmount();
            int new_amount = old_amount + amount;
            cartLines.get(currentLineIndex).setAmount(new_amount);
        }
    }
    
    public void updateLine(Product product, int new_amount) {
        int currentLineIndex = getLineIndex(product);
        if (currentLineIndex != -1) {
            cartLines.get(currentLineIndex).setAmount(new_amount);
        }
    }
    
    public void deleteLine(Product product) {
        int currentLineIndex = getLineIndex(product);
        if (currentLineIndex != -1) {
            cartLines.remove(currentLineIndex);
        }
    }
    
    public void clear(){
        cartLines.clear();
    }

    public List<OrderLine> getCartLines() {
        return cartLines;
    }
    
    public int getTotalProductsAmount() {
        int total = 0;
        for (OrderLine line : cartLines) {
            total += line.getAmount();
        }
        return total;
    }
    
    public double getTotalPrice() {
        double total = 0.0;
        for (OrderLine line : cartLines) {
            total += line.getAmount() * line.getProduct().getPrice();
        }
        return total;
    }
    
    private int getLineIndex(Product product) {
        int currentLineIndex = -1;
        for (int i = 0; i < cartLines.size(); ++i) {
            if (cartLines.get(i).getProduct().equals(product)) {
                currentLineIndex = i;
                break;
            }
        }
        return currentLineIndex;
    }
    
}
