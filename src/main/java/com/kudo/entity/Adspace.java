package com.kudo.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adspace")
public class Adspace extends BaseEntity {

    private String name;

    private String description;

    private AdverType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "adspaceID")
    @Fetch(FetchMode.SUBSELECT)
    private List<Advert> adverts;


    public Adspace() {
    }

    public Adspace(String name, String description, AdverType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public AdverType getType() {
        return type;
    }

    public void modify(Adspace product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.type = product.getType();
    }

}
