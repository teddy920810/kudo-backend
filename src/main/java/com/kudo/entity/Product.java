package com.kudo.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String name;

    private String cover;

    private String seriesID;


    public Product() {
    }

    public Product(String name, String cover, String seriesID) {
        this.name = name;
        this.cover = cover;
        this.seriesID = seriesID;
    }

    public String getName() {
        return name;
    }

    public String getCover() {
        return cover;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSeriesID() {
        return seriesID;
    }

    public void modify(Product product) {
        this.name = product.getName();
        this.cover = product.getCover();
        this.seriesID = product.getSeriesID();
    }

}
