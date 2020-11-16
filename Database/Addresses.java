package com.example.letsbuy.models;
public class Addresses
{
    String StreetAddress,City,State,PostalCode;
    public Addresses(String streetAddress, String city, String state, String postalCode)
    {
        StreetAddress = streetAddress;
        City = city;
        State = state;
        PostalCode = postalCode;
    }
    public String getStreetAddress()
    {
        return StreetAddress;
    }
    public void setStreetAddress(String streetAddress)
    {
        StreetAddress = streetAddress;
    }
    public String getCity()
    {
        return City;
    }
    public void setCity(String city)
    {
        City = city;
    }
    public String getState()
    {
        return State;
    }
    public void setState(String state)
    {
        State = state;
    }
    public String getPostalCode()
    {
        return PostalCode;
    }
    public void setPostalCode(String postalCode)
    {
        PostalCode = postalCode;
    }
}
