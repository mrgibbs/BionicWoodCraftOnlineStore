/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.helpers.PhotoType;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrgibbs
 */
@Entity
@Table(name = "photo")
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p")})
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "photo_name")
    private String photoName;
    
    @Size(max = 100)
    @Column(name = "description")
    private String description;
//    @JoinTable(name = "product_photo", joinColumns = {
//        @JoinColumn(name = "photo_id", referencedColumnName = "id")}, inverseJoinColumns = {
//        @JoinColumn(name = "product_id", referencedColumnName = "id")})
//    @ManyToMany
//    private List<Product> productList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainPhotoId")
//    private List<Product> productList1;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id", nullable = false)
    private List<PhotoFile> photoFileList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "photoId")
//    private List<Category> categoryList;

    public Photo() {
    }
    
    public PhotoFile getSquare200pxPhotoFile() {    //TODO   Maybe it does make a sense to use exception in this function
        PhotoFile appropriateFile = new PhotoFile("nothing.png", PhotoType.SQUARE_200PX);
        for (PhotoFile file : photoFileList){
            if (file.getType().equals(PhotoType.SQUARE_200PX)) {
                appropriateFile = file;
            }
        }
        return appropriateFile;
    }
    
    public PhotoFile getSquare400pxPhotoFile() {    //TODO   Maybe it does make a sense to use exception in this function
        PhotoFile appropriateFile = new PhotoFile("nothing.png", PhotoType.SQUARE_400PX);
        for (PhotoFile file : photoFileList){
            if (file.getType().equals(PhotoType.SQUARE_400PX)) {
                appropriateFile = file;
            }
        }
        return appropriateFile;
    }

    public Photo(Long id) {
        this.id = id;
    }

    public Photo(Long id, String photoName) {
        this.id = id;
        this.photoName = photoName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
//
//    public List<Product> getProductList1() {
//        return productList1;
//    }
//
//    public void setProductList1(List<Product> productList1) {
//        this.productList1 = productList1;
//    }

    public List<PhotoFile> getPhotoFileList() {
        return photoFileList;
    }

    public void setPhotoFileList(List<PhotoFile> photoFileList) {
        this.photoFileList = photoFileList;
    }

//    public List<Category> getCategoryList() {
//        return categoryList;
//    }
//
//    public void setCategoryList(List<Category> categoryList) {
//        this.categoryList = categoryList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.mykhalko.woodcraftonlinestore.entities.Photo[ id=" + id + " ]";
    }
    
}
