package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.Address;
import dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount;
import dev.mykhalko.woodcraftonlinestore.entities.ProductComment;
import dev.mykhalko.woodcraftonlinestore.helpers.UserStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, UserStatus> userStatus;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile ListAttribute<Customer, ProductComment> productCommentList;
    public static volatile SingularAttribute<Customer, String> surname;
    public static volatile ListAttribute<Customer, Address> addressList;
    public static volatile SingularAttribute<Customer, String> hashsalt;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile ListAttribute<Customer, OrderWithAccount> orderWithAccountList;
    public static volatile SingularAttribute<Customer, String> hashpass;
    public static volatile SingularAttribute<Customer, String> email;

}