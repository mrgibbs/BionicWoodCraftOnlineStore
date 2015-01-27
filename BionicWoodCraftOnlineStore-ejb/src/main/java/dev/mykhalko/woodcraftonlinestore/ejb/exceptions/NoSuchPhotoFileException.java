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
public class NoSuchPhotoFileException extends Exception {

    /**
     * Creates a new instance of <code>NoSuchPhotoFileException</code> without
     * detail message.
     */
    public NoSuchPhotoFileException() {
    }

    /**
     * Constructs an instance of <code>NoSuchPhotoFileException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchPhotoFileException(String msg) {
        super(msg);
    }
}
