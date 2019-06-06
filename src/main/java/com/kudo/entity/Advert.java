package com.kudo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "advert")
public class Advert extends BaseEntity {

    private String name;

    private String description;

    private String adspaceID;

    private String imgurl;


    public Advert() {
    }

    public Advert(String name, String description, String adspaceID) {
        this.name = name;
        this.description = description;
        this.adspaceID = adspaceID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAdspaceID() {
        return adspaceID;
    }

}
