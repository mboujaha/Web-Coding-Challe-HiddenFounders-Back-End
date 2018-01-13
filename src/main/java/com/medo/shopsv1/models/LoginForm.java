package com.medo.shopsv1.models;

public class LoginForm {

    private String email;
    private String password;


    public LoginForm() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
