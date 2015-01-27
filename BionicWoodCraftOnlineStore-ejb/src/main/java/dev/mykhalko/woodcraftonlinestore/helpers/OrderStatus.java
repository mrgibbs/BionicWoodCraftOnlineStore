/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.helpers;

/**
 *
 * @author mrgibbs
 */
public enum OrderStatus {
    UNVIEWED("Нове"), 
    COMPLETED("Виконано"),
    EJECTED("Відмовлено"), 
    CONFIRMED("Підтверджене");
    
    private String labelUkr;
    
    private OrderStatus(String labelUkr) {
        this.labelUkr = labelUkr;
    }

    public String getLabelUkr() {
        return labelUkr;
    }
    
    
}
