package com.example.letsbuy.models;
public class Passwords
{
    String Username,NewPassword,ConfirmPassword;
    public Passwords(String username, String newPassword, String confirmPassword)
    {
        Username = username;
        NewPassword = newPassword;
        ConfirmPassword = confirmPassword;
    }
    public String getUsername()
    {
        return Username;
    }
    public void setUsername(String username)
    {
        Username = username;
    }
    public String getNewPassword()
    {
        return NewPassword;
    }
    public void setNewPassword(String newPassword)
    {
        NewPassword = newPassword;
    }
    public String getConfirmPassword()
    {
        return ConfirmPassword;
    }
    public void setConfirmPassword(String confirmPassword)
    {
        ConfirmPassword = confirmPassword;
    }
}
