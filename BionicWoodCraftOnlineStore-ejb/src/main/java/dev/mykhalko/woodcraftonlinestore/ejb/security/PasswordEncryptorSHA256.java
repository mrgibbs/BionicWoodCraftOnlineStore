/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.security;

import dev.mykhalko.woodcraftonlinestore.helpers.HashInfo;
import javax.ejb.Stateless;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author mrgibbs
 */
@Stateless
public class PasswordEncryptorSHA256 implements PasswordEncryptorLocal {

    public String encrypt(String password, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword.toUpperCase();
    }
    
    public HashInfo encrypt(String password) {
        HashInfo hashInfo = new HashInfo();
        
        try {
            hashInfo.setHashsalt(getSalt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            hashInfo.setHashsalt("DefaultSalt_1000");
        }
        
        hashInfo.setHasspass(encrypt(password, hashInfo.getHashsalt()));
        return hashInfo;
    }
    
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
