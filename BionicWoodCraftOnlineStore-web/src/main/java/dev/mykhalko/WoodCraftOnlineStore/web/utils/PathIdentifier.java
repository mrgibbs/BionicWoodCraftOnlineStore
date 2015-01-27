/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.utils;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.PathBarElement;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author mrgibbs
 */
@Named(value = "pathIdentifier")
@RequestScoped
public class PathIdentifier {

    private String sourcePath;
    private List<PathBarElement> pathBarElements;
    private boolean isListReady = false;
    
    

    public List<PathBarElement> getPathBarElements() {
//        if (!isListReady) {
//            createList();
//        }
        return pathBarElements;
    }
    
    public void createList() {
        if (sourcePath != null){
            String[] path_parts = sourcePath.split("/");
            pathBarElements = new ArrayList<>();
            String cur_link = "/browse";
            for (String current_part : path_parts){
                cur_link += "/" + current_part;
                PathBarElement pbe = new PathBarElement(current_part, cur_link);
                pathBarElements.add(pbe);                
            }
        }
        isListReady = true;
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("path_list", pathBarElements);
//        System.out.println("!!!!! List is created: " + pathBarElements);
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
        createList();
    }
    /**
     * Creates a new instance of PathIdentifier
     */
    public PathIdentifier() {
    }
    
    
    
}
