package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.helpers.PhotoType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(PhotoFile.class)
public class PhotoFile_ { 

    public static volatile SingularAttribute<PhotoFile, String> fileName;
    public static volatile SingularAttribute<PhotoFile, Long> id;
    public static volatile SingularAttribute<PhotoFile, PhotoType> type;

}