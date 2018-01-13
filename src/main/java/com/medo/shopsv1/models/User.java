package com.medo.shopsv1.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "users")
public class User{

    @Id
    private String id;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;

    @Indexed(unique = true)
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @DBRef
    private List<Shop> preferredShops;

    public User() {
        this.preferredShops = new ArrayList<>();
    }

    public User(@NotBlank String email, @NotBlank String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Shop> getPreferredShops() {
        return preferredShops;
    }

    public void setPreferredShops(List<Shop> preferredShops) {
        this.preferredShops = preferredShops;
    }
}
