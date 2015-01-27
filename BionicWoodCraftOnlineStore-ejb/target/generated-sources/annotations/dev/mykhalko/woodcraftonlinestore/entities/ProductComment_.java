package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.Customer;
import dev.mykhalko.woodcraftonlinestore.entities.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(ProductComment.class)
public class ProductComment_ { 

    public static volatile SingularAttribute<ProductComment, Product> product;
    public static volatile SingularAttribute<ProductComment, Date> dateCreated;
    public static volatile SingularAttribute<ProductComment, Integer> dislikes;
    public static volatile SingularAttribute<ProductComment, Long> id;
    public static volatile SingularAttribute<ProductComment, String> commentText;
    public static volatile SingularAttribute<ProductComment, Integer> likes;
    public static volatile SingularAttribute<ProductComment, Customer> customer;

}