package com.webtown.webshop.model;

public class Product {

    private int id;
    private String name;
    private String price;
    private String twoEqualsThree;
    private String megaPack;

    public Product() {
    }

    public Product(int id, String name, String price) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
