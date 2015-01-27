package dev.mykhalko.woodcraftonlinestore.entities;

import dev.mykhalko.woodcraftonlinestore.entities.PhotoFile;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-12-23T12:55:41")
@StaticMetamodel(Photo.class)
public class Photo_ { 

    public static volatile ListAttribute<Photo, PhotoFile> photoFileList;
    public static volatile SingularAttribute<Photo, String> description;
    public static volatile SingularAttribute<Photo, Long> id;
    public static volatile SingularAttribute<Photo, String> photoName;

}