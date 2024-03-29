package com.kudo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "site")
public class Site extends BaseEntity {

    private String tel;

    private String email;

    private String address;

    private String qrcode;

    public Site() {
    }

    public Site(String tel, String email, String address, String qrcode) {
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.qrcode = qrcode;
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

    public void modify(Site newSite) {
        this.tel = newSite.getTel();
        this.email = newSite.getEmail();
        this.address = newSite.getAddress();
        this.qrcode = newSite.getQrcode();
    }
}
