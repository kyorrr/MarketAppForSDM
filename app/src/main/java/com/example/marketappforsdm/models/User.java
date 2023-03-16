package com.example.marketappforsdm.models;

public class User {
    private String login, email, phone, pass, pass2;

    public User(){}

    public User(String login, String email, String phone, String pass, String pass2) {
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.pass2 = pass2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}
