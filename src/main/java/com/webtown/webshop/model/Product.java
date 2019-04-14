package com.webtown.webshop.model;

public class Product {

    private int id;
    private String name;
    private int price;
    private String twoEqualsThree;
    private String megaPack;
    private int amount;
    private int totalPrice;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTwoEqualsThree() {
        return twoEqualsThree;
    }

    public void setTwoEqualsThree(String twoEqualsThree) {
        this.twoEqualsThree = twoEqualsThree;
    }

    public String getMegaPack() {
        return megaPack;
    }

    public void setMegaPack(String megaPack) {
        this.megaPack = megaPack;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", twoEqualsThree='" + twoEqualsThree + '\'' +
                ", megaPack='" + megaPack + '\'' +
                '}';
    }
}
