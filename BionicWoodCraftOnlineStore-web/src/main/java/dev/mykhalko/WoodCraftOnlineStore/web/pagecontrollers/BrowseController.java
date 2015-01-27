/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.PathBarElement;
import dev.mykhalko.woodcraftonlinestore.entities.Category;
import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.CategoryFacade;
import dev.mykhalko.woodcraftonlinestore.ejb.exceptions.NoSuchCategoryException;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author mrgibbs
 */
@Named(value = "browseController")
@RequestScoped
public class BrowseController {
    @EJB
    private CategoryFacade categoryFacade;
    
    @Inject
    private InfoPageController infoPageController;
    
    List<PathBarElement> pathBarElementsList;
    List<Category> subCategories;
    List<Product> products;
    boolean containsSubcategoris;
    String currentCategoryLink;

    
    /**
     * Creates a new instance of BrowseController
     */
    public BrowseController() {
    }
    
    public String getBrowsePage(){
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        String jsf_pages_root = ectx.getInitParameter("jsf_pages_root");
        pathBarElementsList = (List<PathBarElement>)ectx.getRequestMap().get("path_list");
        List<String> path_list_str = new ArrayList<>();
        for (PathBarElement pbe : pathBarElementsList){
            path_list_str.add(pbe.getLabel());
        }
        
        
        List<Category> path_category = null;
        try {
            path_category = categoryFacade.getCategoriesByPathList(path_list_str);
        } catch (NoSuchCategoryException e) {
            infoPageController.setInfoPageType(InfoPageType.ERROR);
            infoPageController.setMessage("Помилка. Такої сторінки не існує.");
            return "/WEB-INF/pages/public/info_page.xhtml";
        }
        
        if (path_category == null || path_category.isEmpty()) {
            infoPageController.setInfoPageType(InfoPageType.ERROR);
            infoPageController.setMessage("Внутрішня серверна помилка. Зверніться до адміністратора");
            return "/WEB-INF/pages/public/info_page.xhtml";
        }
        
        if (path_category.size() != pathBarElementsList.size()) {
            throw new RuntimeException("Error. path_category list and path_list have different size");
        }
        
        for (int i = 0; i < path_category.size(); ++i) {
            pathBarElementsList.get(i).setLabelUkr(path_category.get(i).getNameUkr());
        }
        
        subCategories = path_category.get(path_category.size()-1).getSubCategoriesList();
        containsSubcategoris = ( subCategories != null && !subCategories.isEmpty() );
        currentCategoryLink = pathBarElementsList.get(pathBarElementsList.size()-1).getLink();
        
        
        
        Category cur_cat = path_category.get(path_category.size()-1);
        products = cur_cat.getProductList();
        
        
        return "/WEB-INF/pages/public/browse.xhtml";
    }

    public List<Product> getProducts() {
        return products;
    }
    
    
//        
//        
//        
//        
//        
//        if (path_list == null){
//            System.out.println("!!!!! List equals to null");
//            return jsf_pages_root + "browse_error.xhtml";            
//        }
//        Category root_category = null;
//        try {
//            root_category = categoryFacade.findGeneralByName(path_list.get(0).getLabel());
//        } catch (NoResultException e) {
//            //TODO     add maybe some logging
//        }
//        
//        
//        //DEBUG START
//        List<Category> subs = category.getSubCategoriesList();
//        System.out.println("!!! SUBS   !!!");
//        for (Category cat : subs ){
//            System.out.println(cat.getNameUkr());
//        }
//            
//        //DEBUG END
//            
//            
//        if (category == null){
//            return jsf_pages_root + "browse_error_cat.xhtml";
//        }   
//        return "/browse.xhtml";
//    }

    public List<PathBarElement> getPathBarElementsList() {
        return pathBarElementsList;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public boolean isContainsSubcategoris() {
        return containsSubcategoris;
    }

    public String getCurrentCategoryLink() {
        return currentCategoryLink;
    }
    
}
