package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(OrderWithoutAccount.class)
public class OrderWithoutAccount_ extends BasicOrder_ {

    public static volatile SingularAttribute<OrderWithoutAccount, Address> address;
    public static volatile SingularAttribute<OrderWithoutAccount, String> phone;
    public static volatile SingularAttribute<OrderWithoutAccount, String> email;

}