/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.pagecontrollers;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mrgibbs
 */
@Named(value = "testUploadBean_1")
@RequestScoped
public class TestUploadBean_1 {

    private Part mainPhotoFile;
    private StreamedContent content;
    private String mainPhotoFileUrl;

    public Part getMainPhotoFile() {
        return mainPhotoFile;
    }

    public void setMainPhotoFile(Part mainPhotoFile) {
        System.out.println("From setMainPhotoFile   method");
        this.mainPhotoFile = mainPhotoFile;
    }

    
    
    public TestUploadBean_1() {
    }
    
    public void upload(){
        System.out.println("From upload method     :DDD");
        if (mainPhotoFile == null) {
            System.out.println("mainPhotoFile  ==  null");
        }
        try (FileOutputStream fos
                = new FileOutputStream("/home/mrgibbs/Desktop/TESTING.jpg")) {
            int len = (int) mainPhotoFile.getSize();
            byte[] buffer = new byte[len];
            mainPhotoFile.getInputStream().read(buffer, 0, len);
            fos.write(buffer, 0, len);
        } catch (Exception e) {
            System.out.println("Exception while writing TESTING.jpg");
            e.printStackTrace();
        }
        
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("Method was called :)))");
        UploadedFile uf = event.getFile();
        String srcFileName = event.getFile().getFileName();
        String[] nameParts = srcFileName.split("\\.");
        System.out.println("Src File: " + srcFileName + "   Array: " + Arrays.toString(nameParts));
        String fileExtension = nameParts[nameParts.length - 1];
        String appRoot = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        String tempSubPath = FacesContext.getCurrentInstance()
                        .getExternalContext().getInitParameter("temp_files_resource_directory");
        long currentTime = new Date().getTime();
        int random = Math.abs(new Random(currentTime).nextInt());           
        String tempFileName = "picture_" + currentTime + "_" + random + "." + fileExtension;
        try (FileOutputStream fos
                = new FileOutputStream(appRoot + "resources/" + tempSubPath + tempFileName)) {
            int len = (int) uf.getSize();
            byte[] buffer = new byte[len];
            uf.getInputstream().read(buffer, 0, len);
            fos.write(buffer, 0, len);
            System.out.println("File was saved successfully");
            mainPhotoFileUrl = "javax.faces.resource/" + tempSubPath + tempFileName + ".xhtml";
            System.out.println("mainPhotoFileUrl: " + mainPhotoFileUrl);
        } catch (Exception e) {
            System.out.println("Exception while writing uploaded file");
            e.printStackTrace();
        }
        
    }
    
    public void printParameters(String a1, String a2) {
        System.out.println("Call of function printParameters. a1 = " + a1 + "   a2 = " + a2);
        System.out.println(new Date().getTime());
    }
    
    
}
