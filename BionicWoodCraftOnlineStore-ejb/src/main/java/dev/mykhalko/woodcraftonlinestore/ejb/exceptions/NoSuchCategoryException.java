/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.exceptions;

/**
 *
 * @author mrgibbs
 */
public class NoSuchCategoryException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchCategoryException</code> without
     * detail message.
     */
    public NoSuchCategoryException() {
    }

    /**
     * Constructs an instance of <code>NoSuchCategoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchCategoryException(String msg) {
        super(msg);
    }
}
