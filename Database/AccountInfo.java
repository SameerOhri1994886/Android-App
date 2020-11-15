package com.example.letsbuy.models;

public class AccountInfo {
    String FullName, Username, Password, Email, Phone;

    public AccountInfo(String fullName, String username, String password, String email, String phone) {
        FullName = fullName;
        Username = username;
        Password = password;
        Email = email;
        Phone = phone;
    }
 public AccountInfo() {}
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
}