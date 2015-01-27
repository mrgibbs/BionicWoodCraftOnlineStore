package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.Category;
import dev.mykhalko.woodcraftonlinestore.entities.Photo;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> nameEng;
    public static volatile SingularAttribute<Category, String> nameUkr;
    public static volatile SingularAttribute<Category, Category> superCategory;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Photo> photo;
    public static volatile SingularAttribute<Category, Long> id;
    public static volatile ListAttribute<Category, Category> subCategoriesList;
    public static volatile ListAttribute<Category, Product> productList;

}