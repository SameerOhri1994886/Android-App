package com.example.letsbuy.models;
public class Orders
{
    String item,qty,address,city,state,code;
    public Orders(String item, String qty, String address, String city, String state, String code)
    {
        this.item = item;
        this.qty = qty;
        this.address = address;
        this.city = city;
        this.state = state;
        this.code = code;
    }
    public String getItem()
    {
        return item;
    }
    public void setItem(String item)
    {
        this.item = item;
    }
    public String getQty()
    {
        return qty;
    }
    public void setQty(String qty)
    {
        this.qty = qty;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
}
