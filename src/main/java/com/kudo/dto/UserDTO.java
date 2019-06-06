package com.kudo.dto;

import com.kudo.entity.Role;

public class UserDTO {

    private String id;

    private String username;

    private String password;

    private Role role;

    public UserDTO() {
    }

    public UserDTO(String id, String username, Role role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public UserDTO(String id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

}

