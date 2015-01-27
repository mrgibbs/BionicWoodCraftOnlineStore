/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author mrgibbs
 */
@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {
    private static final String errorMsg = "Паролі відрізняються";
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String pass2 = (String) value;
//        String pass1 = (String) component.getAttributes().get("pass1");
        
        UIComponent otherComponent = context.getViewRoot().findComponent("j_idt15:passField");
        String pass1 = (String)((UIInput)otherComponent).getValue();
        
        
        System.out.println("From validator:   pass1 = " + pass1);
        System.out.println("From validator:   pass2 = " + pass2);
        //System.out.println("Attributes: " + component.getAttributes().keySet());
        
        

        if (pass2 == null || pass1 == null) {
            throw new ValidatorException(new FacesMessage(errorMsg));
        }

        if (!pass1.equals(pass2)) {
            throw new ValidatorException(new FacesMessage(errorMsg));
        }
    }

}
