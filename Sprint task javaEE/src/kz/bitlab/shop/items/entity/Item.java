package kz.bitlab.shop.items.entity;

public class Item {
    Long id;
    String name;
    String description;
    double price;

    public Item(){}

    public Item(String name, String description, double price) {
       this.name = name;
       this.description = description;
       this.price = price;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
