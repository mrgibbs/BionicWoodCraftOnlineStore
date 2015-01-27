package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.OrderLine;
import dev.mykhalko.woodcraftonlinestore.helpers.DeliveryType;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(BasicOrder.class)
public class BasicOrder_ { 

    public static volatile SingularAttribute<BasicOrder, Date> dateCreated;
    public static volatile ListAttribute<BasicOrder, OrderLine> orderLineList;
    public static volatile SingularAttribute<BasicOrder, DeliveryType> deliveryType;
    public static volatile SingularAttribute<BasicOrder, OrderStatus> orderStatus;
    public static volatile SingularAttribute<BasicOrder, Long> id;

}