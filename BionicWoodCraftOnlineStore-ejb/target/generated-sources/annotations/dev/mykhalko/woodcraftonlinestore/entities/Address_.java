package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.helpers.SettlementType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, SettlementType> settlementType;
    public static volatile SingularAttribute<Address, String> settlementName;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> oblast;
    public static volatile SingularAttribute<Address, String> buildingNumber;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, String> raion;
    public static volatile SingularAttribute<Address, String> appartmentNumber;

}