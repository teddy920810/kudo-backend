package com.kudo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message extends BaseEntity {

    private String name;

    private String phone;

    private String content;


    public Message() {
    }

    public Message(String name, String phone, String content) {
        this.name = name;
        this.phone = phone;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getContent() {
        return content;
    }
}
