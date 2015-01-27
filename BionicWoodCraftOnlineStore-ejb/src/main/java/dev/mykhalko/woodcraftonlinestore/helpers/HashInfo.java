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
public class HashInfo {
    private String hasspass;
    private String hashsalt;

    public String getHasspass() {
        return hasspass;
    }

    public void setHasspass(String hasspass) {
        this.hasspass = hasspass;
    }

    public String getHashsalt() {
        return hashsalt;
    }

    public void setHashsalt(String hashsalt) {
        this.hashsalt = hashsalt;
    }
    
    
}
