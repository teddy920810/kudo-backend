package com.kudo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @Column(length = 100)
    private String id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void modify(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public void modifyPassword(String password) {
        this.password = password;
    }
}

