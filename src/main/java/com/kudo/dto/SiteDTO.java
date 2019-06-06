package com.kudo.dto;

public class SiteDTO {

    private String id;

    private String tel;

    private String email;

    private String address;

    private String qrcode;

    public SiteDTO() {
    }

    public SiteDTO(String id, String tel, String email, String address, String qrcode) {
        this.id = id;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.qrcode = qrcode;
    }

    public String getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getQrcode() {
        return qrcode;
    }
}
