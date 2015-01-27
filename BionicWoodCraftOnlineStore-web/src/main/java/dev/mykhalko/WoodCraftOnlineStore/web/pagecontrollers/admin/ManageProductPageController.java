/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers.admin;

import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.CategoryHierarchyManager;
import dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers.CropRegion;
import dev.mykhalko.woodcraftonlinestore.ejb.entityfacades.CategoryFacade;
import dev.mykhalko.woodcraftonlinestore.entities.Category;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mrgibbs
 */
@Named(value = "manageProductPageController")
@ViewScoped
public class ManageProductPageController implements Serializable {

    @EJB
    private CategoryFacade categoryFacade;
    
    private final String TEMP_DIR_PARAM = "external_temp_files_dir";
    private final String TEMP_LOC_PARAM = "external_temp_files_loc";
    
    private Product product;    
//    private Category currentCategory;
//    private CategoryHierarchyManager categoryHierarchyManager;
    private List<CategoryHierarchyManager> categoryHierarchyManagers;
    private String mainPhotoFileUrl;
    private CropRegion cropRegion;

    
    @PostConstruct
    private void initPageController() {
//        try {
//            categoryHierarchyManager = new CategoryHierarchyManager(categoryFacade.getRootCategories());
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
        categoryHierarchyManagers = new ArrayList<>();
        categoryHierarchyManagers.add(createManager());
        product = new Product();
    }
    
    public void addCategoryHierarchyManager() {
        categoryHierarchyManagers.add(createManager());
    }
    
    public void removeCategoryHierarchyManager(CategoryHierarchyManager chm) {
        if (categoryHierarchyManagers.size() > 1) {
            categoryHierarchyManagers.remove(chm);
        }
    }
    
    private CategoryHierarchyManager createManager() {
        CategoryHierarchyManager categoryHierarchyManager = null;
        try {
            categoryHierarchyManager = new CategoryHierarchyManager(categoryFacade.getRootCategories());
            return categoryHierarchyManager;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public String getMainPhotoFileUrl() {
        return mainPhotoFileUrl;
    }

    public void setMainPhotoFileUrl(String mainPhotoFileUrl) {
        this.mainPhotoFileUrl = mainPhotoFileUrl;
    }
    
    public void handleFileUpload(FileUploadEvent event) {
//        System.out.println("Method was called :)))");
        UploadedFile uf = event.getFile();
        String srcFileName = event.getFile().getFileName();
        String[] nameParts = srcFileName.split("\\.");
//        System.out.println("Src File: " + srcFileName + "   Array: " + Arrays.toString(nameParts));
        String fileExtension = nameParts[nameParts.length - 1];
//        String appRoot = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
//        String tempSubPath = FacesContext.getCurrentInstance()
//                .getExternalContext().getInitParameter("temp_files_resource_directory");
        String tempFilesDir = FacesContext.getCurrentInstance().getExternalContext()
                .getInitParameter(TEMP_DIR_PARAM);
        long currentTime = new Date().getTime();
        int random = Math.abs(new Random(currentTime).nextInt());
        String tempFileName = "picture_" + currentTime + "_" + random + "." + fileExtension;
        try (FileOutputStream fos
                = new FileOutputStream(tempFilesDir + tempFileName)) {
            int len = (int) uf.getSize();
            byte[] buffer = new byte[len];
            uf.getInputstream().read(buffer, 0, len);
            fos.write(buffer, 0, len);
//            System.out.println("File was saved successfully");
            String tempFileLoc = FacesContext.getCurrentInstance().getExternalContext()
                    .getInitParameter(TEMP_LOC_PARAM);
            mainPhotoFileUrl = tempFileLoc + tempFileName;
            System.out.println("mainPhotoFileUrl: " + mainPhotoFileUrl);
        } catch (Exception e) {
            System.out.println("Exception while writing uploaded file");
            e.printStackTrace();
        }

    }
    

    public void setCropRegion(CropRegion cropRegion) {
        this.cropRegion = cropRegion;
        System.out.println("cropRegion: x=" + cropRegion.getX() + "   y=" + cropRegion.getY() 
                + "   width=" + cropRegion.getWidth()
                + "   height=" + cropRegion.getHeight() );
    }

    
    
    public ManageProductPageController() {
        
    }
    
    public Product.Status[] getStatuses() {
        return Product.Status.values();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void addNewProduct() {
        
    }
    
    public void updateProduct() {
        
    }

//    public CategoryHierarchyManager getCategoryHierarchyManager() {
//        return categoryHierarchyManager;
//    }
//
//    public void setCategoryHierarchyManager(CategoryHierarchyManager categoryHierarchyManager) {
//        this.categoryHierarchyManager = categoryHierarchyManager;
//    }
//    
//    public void handler10(AjaxBehaviorEvent event) {
//        System.out.println("Bingos!");
//    }
//    
//    public void handler15() {
//        System.out.println("Bingos! 15");
//    }

    public List<CategoryHierarchyManager> getCategoryHierarchyManagers() {
        return categoryHierarchyManagers;
    }
    
    

    
    
    
}
