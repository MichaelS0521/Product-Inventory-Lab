package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private float size;
    private int qty;
    private float price;

    public Sneaker(int id, String name, String brand, String sport, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.qty = qty;
        this.price = price;
    }

    public Sneaker(int id, String name, String brand, String sport, float size, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getSport() {
        return sport;
    }

    public int getQty() {
        return qty;
    }

    public float getPrice() {
        return price;
    }
}
