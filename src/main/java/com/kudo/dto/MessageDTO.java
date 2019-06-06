package com.kudo.dto;

public class MessageDTO {

    private String id;

    private String name;

    private String phone;

    private String content;

    public MessageDTO() {
    }

    public MessageDTO(String id, String name, String phone, String content) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.content = content;
    }

    public String getId() {
        return id;
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
