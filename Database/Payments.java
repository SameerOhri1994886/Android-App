package com.example.letsbuy.models;
public class Payments
{
    String Name,Date;
    public Payments(String name, String date)
    {
        Name = name;
        Date = date;

    }
    public String getName()
    {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
}
