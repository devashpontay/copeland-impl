package com.dt.copeland.model;

import jakarta.persistence.*;

@Entity
@Table(name = User.ENTITY_NAME)
public class User {

    public static final String ENTITY_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNo;

    private String name;
    private String username;
    private String password;

    public User(Long idNo, String name, String username, String password) {
        this.idNo = idNo;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
