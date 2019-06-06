package com.kudo.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "series")
public class Series extends BaseEntity {

    private String name;

    private String  parentID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentID")
    @Fetch(FetchMode.SUBSELECT)
    private List<Series> children;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "seriesID")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}
