package com.medo.shopsv1.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "shops")
public class Shop {

    @Id
    private String _id;

    @NotBlank
    private String picture;

    @NotBlank
    private String name;


    @NotBlank
    private String email;

    @NotBlank
    private String city;

    @NotBlank
    private Location location;

    public Shop(@NotBlank String picture, @NotBlank String email, @NotBlank String city, @NotBlank Location location) {
        this.picture = picture;
        this.email = email;
        this.city = city;
        this.location = location;
    }

    public Shop() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
