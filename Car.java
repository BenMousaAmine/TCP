package org.example;

public class Car {
    private int id;
    private String brand ;
    private double price ;

    public Car(int id ,String brand, double price) {
        this.setBrand(brand);
        this.setPrice(price);
        this.setId(id);
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(!brand.equals("")){
            this.brand = brand;
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }

    }



}
