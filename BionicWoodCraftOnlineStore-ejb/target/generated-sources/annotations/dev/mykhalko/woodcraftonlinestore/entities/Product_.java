package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.Category;
import dev.mykhalko.woodcraftonlinestore.entities.Photo;
import dev.mykhalko.woodcraftonlinestore.entities.Product.Status;
import dev.mykhalko.woodcraftonlinestore.entities.ProductComment;
import dev.mykhalko.woodcraftonlinestore.entities.ProductFeature;
import dev.mykhalko.woodcraftonlinestore.entities.ProductNumericFeature;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile ListAttribute<Product, Photo> photoList;
    public static volatile ListAttribute<Product, ProductFeature> productFeatureList;
    public static volatile ListAttribute<Product, ProductComment> productCommentList;
    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, Date> lastUpdate;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile ListAttribute<Product, Category> categoryList;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Photo> mainPhoto;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile ListAttribute<Product, ProductNumericFeature> productNumericFeatureList;
    public static volatile SingularAttribute<Product, Status> status;

}