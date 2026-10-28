package com.pluralsight;

public class Product {

    private String name;// = "item";
    private String id;// = "0010";
    private double price;// = 0.0;
    private int count;
    //public Product() {}

    public Product(String name, String id, double price, int count) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
    }

    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String toRow() {
        return id + "|" + name + "|" + String.format("%.2f, %d", price, count);
    }
}
