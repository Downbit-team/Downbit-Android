package com.example.downbitjava;

public class ProfileData {
    public String name;
    public int increase;
    public double upping;
    public int price;

    public ProfileData(String name, int increase, double rate_of_change, int price) {
        this.name = name;
        this.increase = increase;
        this.upping = rate_of_change;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getIncrease() {
        return increase;
    }

    public double getRate_of_change() {
        return upping;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public void setRate_of_change(int rate_of_change) {
        this.upping = rate_of_change;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

