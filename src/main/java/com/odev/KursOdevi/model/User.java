package com.odev.KursOdevi.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String name,surname,email,password;

    public User(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
