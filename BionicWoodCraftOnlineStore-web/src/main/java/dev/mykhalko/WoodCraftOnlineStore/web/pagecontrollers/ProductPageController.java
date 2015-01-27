/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.InfoPageType;
import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.ProductFacade;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author mrgibbs
 */
@Named(value = "productPageController")
@RequestScoped
public class ProductPageController {
    @EJB
    private ProductFacade productFacade;
    
    @Inject
    private InfoPageController infoPageController;
    
    private Product currentProduct;
    private String priceFormatted;
        
    private String urlId;
    /**
     * Creates a new instance of ProductPageController
     */
    public ProductPageController() {
//        System.out.println("ProductPageController created");
    }
    
//    @PreDestroy
//    public void predestroymethod(){
//        System.out.println("ProductPageController destroyed");
//    }
    
    public String getProductPage() {
        currentProduct = null;
        currentProduct = productFacade.find(Long.parseLong(urlId));
        if (currentProduct == null) {
            infoPageController.setInfoPageType(InfoPageType.ERROR);
            infoPageController.setMessage("Помилка. Такої сторінки не існує.");
            return "/WEB-INF/pages/public/info_page.xhtml";
        }
        priceFormatted = String.format("%.2f", currentProduct.getPrice());
        return "/WEB-INF/pages/public/product_page.xhtml";
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }
    
    

   
    
    
}
