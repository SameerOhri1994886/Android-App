package com.example.letsbuy.modals;

import com.google.gson.annotations.SerializedName;

public class Post {
    
    private String FullName;
    private String Username;
    private String Password;
    private String Email;
    private String Phone;
    private String StreetAddress=" 2150,Downtown ";
    private String City=" Montreal ";
    private String State=" Quebec ";
    private String PostalCode=" H3H1L2 ";

    @SerializedName("body")
    private String text;

    public Post(String fullName, String username, String password, String email, String phone) {
        FullName = fullName;
        Username = username;
        Password = password;
        Email = email;
        Phone = phone;
    }


    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}