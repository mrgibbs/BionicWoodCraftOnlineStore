/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.security;

import javax.ejb.Local;
import dev.mykhalko.woodcraftonlinestore.helpers.HashInfo;

/**
 *
 * @author mrgibbs
 */
@Local
public interface PasswordEncryptorLocal {
    public String encrypt(String password, String salt);
    public HashInfo encrypt(String password);
}
