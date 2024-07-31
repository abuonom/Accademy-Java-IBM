package com.sistemi.informativi.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable {

    private int id;
    private String name;
    private String email;

    public CustomerVO(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public CustomerVO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
